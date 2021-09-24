package app.alexanastasyev.planner.ui.screens.home

import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.ui.views.ContextView
import app.alexanastasyev.planner.ui.views.HeaderView

interface HomeView : HeaderView, ContextView {
    fun showNotes(notes: List<Note>)
    fun showError(text: String)
}