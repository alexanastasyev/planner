package app.alexanastasyev.planner.ui.screens.home

import app.alexanastasyev.planner.ui.screens.Presenter
import java.util.*

class HomePresenter(private val view: HomeView) : Presenter{

    override fun init() {
        view.displayDate(Calendar.getInstance().time)
    }

}