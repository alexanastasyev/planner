package app.alexanastasyev.planner.ui.screens.note

import app.alexanastasyev.planner.utils.BackgroundTaskExecutor
import app.alexanastasyev.planner.utils.DateFormatter
import dagger.Module
import dagger.Provides

@Module
class NoteModule {

    @Provides
    fun getNotePresenter(
        noteView: NoteView,
        dateFormatter: DateFormatter,
        backgroundTaskExecutor: BackgroundTaskExecutor
    ): NotePresenter {
        return NotePresenter(noteView, dateFormatter, backgroundTaskExecutor)
    }
}