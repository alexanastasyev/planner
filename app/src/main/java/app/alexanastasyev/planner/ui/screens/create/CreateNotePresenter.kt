package app.alexanastasyev.planner.ui.screens.create

import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.utils.DatabaseUtils
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.ui.Presenter
import app.alexanastasyev.planner.utils.BackgroundTaskExecutor

class CreateNotePresenter(private val view: CreateNoteView) : Presenter() {

    override fun init() {
        view.setTitle(view.provideContext().getString(R.string.create_note))
    }

    fun saveNote(note: Note) {
        BackgroundTaskExecutor.executeBackgroundTask({
            val database = DatabaseUtils.getDatabase(view.provideContext())
            database.noteDao().insert(note)
        }, {
            view.showMessage(view.provideContext().getString(R.string.note_saved))
        })
    }
}