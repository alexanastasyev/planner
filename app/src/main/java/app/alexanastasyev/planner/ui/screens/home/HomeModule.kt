package app.alexanastasyev.planner.ui.screens.home

import app.alexanastasyev.planner.utils.BackgroundTaskExecutor
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun getHomePresenter(homeView: HomeView, backgroundTaskExecutor: BackgroundTaskExecutor): HomePresenter {
        return HomePresenter(homeView, backgroundTaskExecutor)
    }
}