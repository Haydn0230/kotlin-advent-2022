package event

import java.util.UUID

data class Event(
    val eventId: UUID,
    val category: String,
    val subCategory: String,
    val name: String,
    val startTime: Long,
    val displayed: Boolean,
    val suspended: Boolean,
)
