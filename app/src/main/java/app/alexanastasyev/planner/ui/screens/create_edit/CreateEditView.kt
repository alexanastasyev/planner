package app.alexanastasyev.planner.ui.screens.create_edit

import app.alexanastasyev.planner.ui.views.ContextView
import app.alexanastasyev.planner.ui.views.HeaderView
import app.alexanastasyev.planner.ui.views.NavigationView

interface CreateEditView : HeaderView, ContextView, NavigationView {
    fun showMessage(text: String)
}