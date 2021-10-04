package app.alexanastasyev.planner.database

import androidx.room.*
import app.alexanastasyev.planner.domain.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note ORDER BY date DESC")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getById(id: Long): Note

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}