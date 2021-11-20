package app.alexanastasyev.planner.ui.screens.home

import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.ui.views.ContextView
import app.alexanastasyev.planner.ui.views.HeaderView
import app.alexanastasyev.planner.ui.views.NavigationView

interface HomeView : HeaderView, ContextView, NavigationView {
    fun showNotes(notes: List<Note>)
    fun showError(text: String)
}