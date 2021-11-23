package app.alexanastasyev.planner.ui.screens.note

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [NoteModule::class])
interface NoteComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun view(noteView: NoteView): Builder
        fun build(): NoteComponent
    }

    fun getNotePresenter(): NotePresenter
}