package app.alexanastasyev.planner.ui.screens.home

import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun getHomePresenter(homeView: HomeView): HomePresenter {
        return HomePresenter(homeView)
    }
}