package app.alexanastasyev.planner.utils

import kotlinx.coroutines.*

object BackgroundTaskExecutor {
    private var job = Job()

    fun executeBackgroundTask(
        task: suspend () -> Unit,
        onFinish: () -> Unit = {}
    ) {
        val uiScope = CoroutineScope(Dispatchers.Main + job)
        uiScope.launch(Dispatchers.IO) {
            task()
            withContext(Dispatchers.Main) {
                onFinish()
            }
        }
    }

    fun cancel() {
        job.cancel()
    }
}