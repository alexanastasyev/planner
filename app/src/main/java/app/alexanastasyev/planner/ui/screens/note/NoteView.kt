package app.alexanastasyev.planner.ui.screens.note

import app.alexanastasyev.planner.ui.views.ContextView
import app.alexanastasyev.planner.ui.views.HeaderView

interface NoteView : HeaderView, ContextView {
    fun showText(text: String)
    fun showDate(date: String)
    fun showTime(time: String)
}