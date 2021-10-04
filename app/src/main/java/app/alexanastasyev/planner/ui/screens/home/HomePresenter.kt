package app.alexanastasyev.planner.ui.screens.home

import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.utils.DatabaseUtils
import app.alexanastasyev.planner.ui.Presenter
import app.alexanastasyev.planner.utils.BackgroundTaskExecutor
import java.text.SimpleDateFormat
import java.util.*

class HomePresenter(private val view: HomeView) : Presenter() {

    companion object {
        private const val DATE_FORMAT = "d MMMM"
        private const val DAY_OF_WEEK_FORMAT = "EEEE"
    }

    override fun init() {
        view.setTitle(getFormattedDate())
        loadNotesFromDatabase()
    }

    private fun getFormattedDate(): String {
        val dateTime = Calendar.getInstance().time
        val dateAsString = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(dateTime)
        val dayOfWeekAsString = SimpleDateFormat(DAY_OF_WEEK_FORMAT, Locale.getDefault()).format(dateTime)
        return "$dateAsString, $dayOfWeekAsString"
    }

    private fun loadNotesFromDatabase() {
        val notes: MutableList<Note> = mutableListOf()
        BackgroundTaskExecutor.executeBackgroundTask({
            val database = DatabaseUtils.getDatabase(view.provideContext())
            notes.addAll(database.noteDao().getAll())
        }, {
            view.showNotes(notes)
        })
    }
}