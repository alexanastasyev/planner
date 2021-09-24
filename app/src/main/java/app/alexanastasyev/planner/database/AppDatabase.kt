package app.alexanastasyev.planner.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.alexanastasyev.planner.domain.Note

@Database(
    entities = [Note::class],
    version = 1
)
@TypeConverters(
    PriorityConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}