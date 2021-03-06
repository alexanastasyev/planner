package app.alexanastasyev.planner.ui.screens.home

import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.database.AppDatabase
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.ui.Presenter
import app.alexanastasyev.planner.utils.BackgroundTaskExecutor
import app.alexanastasyev.planner.utils.NotesController
import java.text.SimpleDateFormat
import java.util.*

class HomePresenter(
    private val view: HomeView,
    private val backgroundTaskExecutor: BackgroundTaskExecutor
) : Presenter() {

    companion object {
        private const val DATE_FORMAT = "d MMMM"
        private const val DAY_OF_WEEK_FORMAT = "EEEE"
    }

    override fun init() {
        view.setTitle(getFormattedDate())
        loadNotesFromDatabase()
    }

    fun noteClicked(position: Int) {
        NotesController.setCurrentNote(position)
        view.provideNavController().navigate(R.id.action_homeScreen_to_noteScreen)
    }

    private fun getFormattedDate(): String {
        val dateTime = Calendar.getInstance().time
        val dateAsString = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(dateTime)
        val dayOfWeekAsString = SimpleDateFormat(DAY_OF_WEEK_FORMAT, Locale.getDefault()).format(dateTime)
        return "$dateAsString, $dayOfWeekAsString"
    }

    private fun loadNotesFromDatabase() {
        val notes: MutableList<Note> = mutableListOf()
        backgroundTaskExecutor.executeBackgroundTask({
            val database = AppDatabase.getInstance(view.provideContext())
            notes.addAll(database.noteDao().getAll())
        }, {
            NotesController.setNotes(notes)
            view.showNotes(notes)
        })
    }
}