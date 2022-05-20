package com.feedme.models

import com.feedme.numberToBoolean

sealed class Body(
    open val name: String,
    open val displayed: Boolean,
    open val suspended: Boolean
)

data class Event(
    val eventId: String,
    val category: String,
    val subCategory: String,
    val startTime: Long,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
) : Body(name, displayed, suspended) {
    object Position {
        const val eventId = 4
        const val category = 5
        const val subCategory = 6
        const val name = 7
        const val startTime = 8
        const val displayed = 9
        const val suspended = 10
    }
}

data class Market(
    val eventId: String,
    val marketId: String,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
) : Body(name, displayed, suspended) {
    object Position {
        const val eventId = 4
        const val marketId = 5
        const val name = 6
        const val displayed = 7
        const val suspended = 8
    }
}

data class Outcome(
    val marketId: String,
    val outcomeId: String,
    val price: String,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
) : Body(name, displayed, suspended){
    object Position {
        const val marketId = 4
        const val outcomeId = 5
        const val name = 6
        const val price = 7
        const val displayed = 8
        const val suspended = 9
    }
}

fun createOutcome(lines: List<String>): Outcome {
    return Outcome(
        marketId = lines[Outcome.Position.marketId],
        outcomeId = lines[Outcome.Position.outcomeId],
        name = lines[Outcome.Position.name],
        price = lines[Outcome.Position.price],
        displayed = lines[Outcome.Position.displayed].numberToBoolean(),
        suspended = lines[Outcome.Position.suspended].numberToBoolean()
    )
}


fun createMarket(lines: List<String>): Market {
    // don't like grabbing by index position - feels brittle
    // maybe could use reflection rather than grabbing by index position?
    // makes it more flexible so when we update the shape of the
    // object we don't need to update the index position
    // error handling if index out of range?
    return Market(
        eventId = lines[Market.Position.eventId],
        marketId = lines[Market.Position.marketId],
        name = lines[Market.Position.name],
        displayed = lines[Market.Position.displayed].numberToBoolean(),
        suspended = lines[Market.Position.suspended].numberToBoolean()
    )
}

fun createEvent(lines: List<String>): Event {
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
