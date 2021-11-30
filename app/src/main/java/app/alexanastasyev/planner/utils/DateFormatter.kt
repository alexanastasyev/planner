package app.alexanastasyev.planner.utils

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {
    companion object {
        private const val EMPTY_STRING = ""
    }

    fun formatDate(date: Long?, template: String): String {
        return if (date == null) {
            EMPTY_STRING
        } else {
            SimpleDateFormat(template, Locale.getDefault()).format(date)
        }
    }
}