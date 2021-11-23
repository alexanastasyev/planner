package app.alexanastasyev.planner.ui.screens.create_edit

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [CreateEditModule::class])
interface CreateEditComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun view(createEditView: CreateEditView): Builder
        fun build(): CreateEditComponent
    }

    fun getCreateEditPresenter(): CreateEditPresenter
}