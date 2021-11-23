package app.alexanastasyev.planner.ui.screens.home

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun view(homeView: HomeView): Builder
        fun build(): HomeComponent
    }

    fun getHomePresenter(): HomePresenter
}