package app.alexanastasyev.planner.utils

object NavigationUtils {
    var onTimeSelected: (time: Long) -> Unit = {}
    var currentTime: Long = 0

    var onDeleteConfirm: () -> Unit = {}
}