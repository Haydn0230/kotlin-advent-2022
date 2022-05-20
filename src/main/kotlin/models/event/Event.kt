package models.event

import boolean.numberToBoolean
import models.body.Body

data class Event (
    val eventId: String,
    val category: String,
    val subCategory: String,
    val startTime: Long,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
): Body {
    object Position {
        const val eventId =4
        const val category = 5
        const val subCategory=6 
        const val name = 7
        const val startTime= 8
        const val displayed=9 
        const val suspended = 10 
    }
}

fun createEvent(lines:List<String>):Event {
    return Event(
        eventId = lines[Event.Position.eventId],
        category = lines[Event.Position.category],
        subCategory = lines[Event.Position.subCategory],
        name = lines[Event.Position.name],
        startTime = lines[Event.Position.startTime].toLong(),
        displayed = lines[Event.Position.displayed].numberToBoolean(),
        suspended = lines[Event.Position.suspended].numberToBoolean()
    )
}
