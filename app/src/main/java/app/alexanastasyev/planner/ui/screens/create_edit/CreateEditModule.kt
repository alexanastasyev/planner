package app.alexanastasyev.planner.ui.screens.create_edit

import dagger.Module
import dagger.Provides

@Module
class CreateEditModule {

    @Provides
    fun getCreateEditPresenter(createEditView: CreateEditView): CreateEditPresenter {
        return CreateEditPresenter(createEditView)
    }
}