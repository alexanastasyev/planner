package app.alexanastasyev.planner.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @ColumnInfo(name = "text")
    var text: String,

    @ColumnInfo(name = "date")
    var date: Long?,

    @ColumnInfo(name = "priority")
    var priority: Priority
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}