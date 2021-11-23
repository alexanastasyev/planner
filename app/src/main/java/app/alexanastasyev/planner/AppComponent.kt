package app.alexanastasyev.planner

import app.alexanastasyev.planner.ui.screens.create_edit.AbstractCreateEditFragment
import app.alexanastasyev.planner.ui.screens.home.HomeFragment
import app.alexanastasyev.planner.ui.screens.note.NoteFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectHomeScreen(homeFragment: HomeFragment)
    fun injectNoteScreen(noteFragment: NoteFragment)
    fun injectCreateEditFragment(createEditFragment: AbstractCreateEditFragment)
}