package app.alexanastasyev.planner.ui.screens.note

import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.ui.Presenter
import app.alexanastasyev.planner.utils.DateFormatter
import app.alexanastasyev.planner.utils.NotesRepository

class NotePresenter(private val view: NoteView) : Presenter() {

    companion object {
        private const val DATE_FORMAT = "dd.MM.yyyy"
        private const val TIME_FORMAT = "HH:mm"
    }

    override fun init() {
        showNoteInfo(NotesRepository.getCurrentNote())
    }

    private fun showNoteInfo(note: Note) {
        view.setTitle(view.provideContext().getString(R.string.note_view))
        view.showText(note.text)
        if (note.date != null) {
            view.showDate(DateFormatter.formatDate(note.date, DATE_FORMAT))
            view.showTime(DateFormatter.formatDate(note.date, TIME_FORMAT))
        }
    }
}