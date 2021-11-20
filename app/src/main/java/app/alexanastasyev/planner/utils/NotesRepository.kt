package app.alexanastasyev.planner.utils

import app.alexanastasyev.planner.domain.Note

object NotesRepository {
    private val notes: MutableList<Note> = mutableListOf()

    private lateinit var currentNote: Note

    fun setNotes(notes: List<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
    }

    fun getNotes(): List<Note> {
        return this.notes
    }

    fun setCurrentNote(position: Int) {
        this.currentNote = this.notes[position]
    }

    fun getCurrentNote(): Note {
        return this.currentNote
    }
}