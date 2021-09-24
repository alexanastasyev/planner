package app.alexanastasyev.planner.domain

enum class Priority(private val priorityLevel: Int) {

    HIGH(300),
    MEDIUM(200),
    LOW(100);

    fun getPriorityLevel(): Int {
        return priorityLevel
    }
}