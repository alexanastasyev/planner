package app.alexanastasyev.planner.ui.screens.create_edit

import app.alexanastasyev.planner.utils.BackgroundTaskExecutor
import app.alexanastasyev.planner.utils.NotesController
import dagger.Module
import dagger.Provides

@Module
class CreateEditModule {

    @Provides
    fun getCreateEditPresenter(
        createEditView: CreateEditView,
        backgroundTaskExecutor: BackgroundTaskExecutor
    ): CreateEditPresenter {
        return CreateEditPresenter(createEditView, backgroundTaskExecutor)
    }
}