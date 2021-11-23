package app.alexanastasyev.planner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.alexanastasyev.planner.domain.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    PriorityConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NotesDao

    companion object {
        private const val DATABASE_NAME = "notes"

        private var database: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            if (database == null) {
                database = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
            }
            return database!!
        }
    }
}