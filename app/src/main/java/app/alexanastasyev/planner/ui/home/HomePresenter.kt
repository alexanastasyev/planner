package app.alexanastasyev.planner.ui.home

import java.util.*

class HomePresenter(private val view: HomeView) {

    fun init() {
        view.displayDate(Calendar.getInstance().time)
    }

}