package app.alexanastasyev.planner.ui.screens.create

import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.database.AppDatabase
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.ui.Presenter
import app.alexanastasyev.planner.utils.BackgroundTaskExecutor

class CreateNotePresenter(private val view: CreateNoteView) : Presenter() {

    override fun init() {
        view.setTitle(view.provideContext().getString(R.string.create_note))
    }

    fun saveNote(note: Note) {
        if (note.text.isNotBlank()) {
            BackgroundTaskExecutor.executeBackgroundTask({
                val database = AppDatabase.getInstance(view.provideContext())
                database.noteDao().insert(note)
            }, {
                showViewMessage(R.string.note_saved)
            })
        } else {
            showViewMessage(R.string.note_text_is_empty)
        }
    }

    private fun showViewMessage(stringResource: Int) {
        view.showMessage(view.provideContext().getString(stringResource))
    }
}