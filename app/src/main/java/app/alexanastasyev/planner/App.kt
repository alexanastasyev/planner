package app.alexanastasyev.planner

import android.app.Application

class App : Application() {
    companion object{
        val appComponent: AppComponent = DaggerAppComponent.create()
    }
}