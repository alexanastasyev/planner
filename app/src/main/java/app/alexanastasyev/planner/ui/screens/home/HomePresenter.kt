package app.alexanastasyev.planner.ui.screens.home

import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.ui.Presenter
import java.text.SimpleDateFormat
import java.util.*

class HomePresenter(private val view: HomeView) : Presenter() {

    companion object {
        private const val DATE_FORMAT = "d MMMM"
        private const val DAY_OF_WEEK_FORMAT = "EEEE"
    }

    override fun init() {
        view.setTitle(getFormattedDate())
    }

    private fun getFormattedDate(): String {
        val dateTime = Calendar.getInstance().time
        val dateAsString = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(dateTime)
        val dayOfWeekAsString = SimpleDateFormat(DAY_OF_WEEK_FORMAT, Locale.getDefault()).format(dateTime)
        return "$dateAsString, $dayOfWeekAsString"
    }
}