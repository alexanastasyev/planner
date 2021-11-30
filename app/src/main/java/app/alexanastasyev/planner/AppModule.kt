package app.alexanastasyev.planner

import app.alexanastasyev.planner.ui.screens.create_edit.CreateEditComponent
import app.alexanastasyev.planner.ui.screens.home.HomeComponent
import app.alexanastasyev.planner.ui.screens.note.NoteComponent
import app.alexanastasyev.planner.utils.DateFormatter
import dagger.Module
import dagger.Provides

@Module(subcomponents = [HomeComponent::class, NoteComponent::class, CreateEditComponent::class])
class AppModule {

}