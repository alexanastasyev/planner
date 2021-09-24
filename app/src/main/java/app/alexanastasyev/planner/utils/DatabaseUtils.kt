package app.alexanastasyev.planner.utils

import android.content.Context
import androidx.room.Room
import app.alexanastasyev.planner.database.AppDatabase

object DatabaseUtils {
    private const val DATABASE_NAME = "notes"

    private var database: AppDatabase? = null

    fun getDatabase(context: Context) : AppDatabase {
        if (database == null) {
            database = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
        }
        return database!!
    }
}