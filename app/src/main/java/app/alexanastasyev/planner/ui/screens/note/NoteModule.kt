package app.alexanastasyev.planner.ui.screens.note

import dagger.Module
import dagger.Provides

@Module
class NoteModule {

    @Provides
    fun getNotePresenter(noteView: NoteView): NotePresenter {
        return NotePresenter(noteView)
    }
}