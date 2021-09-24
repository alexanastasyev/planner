package app.alexanastasyev.planner.ui.screens.create

import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.ui.Presenter

class CreateNotePresenter(private val view: CreateNoteView) : Presenter() {
    override fun init() {
        view.setTitle(view.provideContext().getString(R.string.create_note))
    }
}