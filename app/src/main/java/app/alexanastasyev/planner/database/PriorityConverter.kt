package app.alexanastasyev.planner.database

import androidx.room.TypeConverter
import app.alexanastasyev.planner.domain.Priority

class PriorityConverter {
    @TypeConverter
    fun fromLevelToPriority(priorityLevel: Int): Priority {
        for (priority in Priority.values()) {
            if (priorityLevel == priority.getPriorityLevel()) {
                return priority
            }
        }
        return Priority.MEDIUM
    }

    @TypeConverter
    fun fromPriorityToPriorityLevel(priority: Priority): Int {
        return priority.getPriorityLevel()
    }
}