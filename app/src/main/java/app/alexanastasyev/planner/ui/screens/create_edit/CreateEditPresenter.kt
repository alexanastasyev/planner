package app.alexanastasyev.planner.ui.screens.create_edit

import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.database.AppDatabase
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.ui.Presenter
import app.alexanastasyev.planner.utils.BackgroundTaskExecutor
import app.alexanastasyev.planner.utils.NotesController

class CreateEditPresenter(private val view: CreateEditView) : Presenter() {

    override fun init() {
        view.setTitle(view.provideContext().getString(R.string.create_note))
    }

    fun save(note: Note) {
        if (note.text.isNotBlank()) {
            if (note.id == null) {
                saveNote(note)
            } else {
                updateNote(note)
            }
        } else {
            showViewMessage(R.string.note_text_is_empty)
        }
    }

    private fun saveNote(note: Note) {
        BackgroundTaskExecutor.executeBackgroundTask(
            task = {
                AppDatabase.getInstance(view.provideContext()).noteDao().insert(note)
            },
            onFinish = {
                view.provideNavController().popBackStack(R.id.homeScreen, false)
            }
        )
    }

    private fun updateNote(note: Note) {
        BackgroundTaskExecutor.executeBackgroundTask(
            task = {
                AppDatabase.getInstance(view.provideContext()).noteDao().update(note)
                NotesController.setCurrentNote(note)
            },
            onFinish = {
                view.provideNavController().popBackStack(R.id.noteScreen, false)
            }
        )
    }

    private fun showViewMessage(stringResource: Int) {
        view.showMessage(view.provideContext().getString(stringResource))
    }
}