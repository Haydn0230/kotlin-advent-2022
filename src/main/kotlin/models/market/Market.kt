package models.market

import boolean.numberToBoolean
import models.body.Body

data class Market(
    val eventId: String,
    val marketId: String,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
) : Body {
    object Position {
        const val eventId = 4
        const val marketId = 5
        const val name = 6
        const val displayed = 7
        const val suspended = 8
    }
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
