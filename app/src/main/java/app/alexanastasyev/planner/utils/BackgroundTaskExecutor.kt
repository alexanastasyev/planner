package app.alexanastasyev.planner.utils

import kotlinx.coroutines.*
import javax.inject.Inject

class BackgroundTaskExecutor @Inject constructor() {
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