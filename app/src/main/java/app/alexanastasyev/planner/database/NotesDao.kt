package app.alexanastasyev.planner.database

import androidx.room.*
import app.alexanastasyev.planner.domain.Note

@Dao
interface NotesDao {
    @Query("SELECT * FROM note ORDER BY date ASC")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getById(id: Long): Note

    @Query("SELECT EXISTS(SELECT * FROM note WHERE id = :id)")
    fun exists(id: Long): Boolean

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}