package app.alexanastasyev.planner.ui.screens.create

import app.alexanastasyev.planner.ui.views.ContextView
import app.alexanastasyev.planner.ui.views.HeaderView
import app.alexanastasyev.planner.ui.views.NavigationView

interface CreateNoteView : HeaderView, ContextView, NavigationView {
    fun showMessage(text: String)
}