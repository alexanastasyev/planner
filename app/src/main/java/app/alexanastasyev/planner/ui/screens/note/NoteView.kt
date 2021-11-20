package app.alexanastasyev.planner.ui.screens.note

import app.alexanastasyev.planner.ui.views.ContextView
import app.alexanastasyev.planner.ui.views.HeaderView
import app.alexanastasyev.planner.ui.views.NavigationView

interface NoteView : HeaderView, ContextView, NavigationView {
    fun showText(text: String)
    fun showDate(date: String)
    fun showTime(time: String)
}