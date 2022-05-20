package models.message

import event
import market
import models.header.Header
import models.body.Body
import models.event.createEvent
import models.header.createHeader
import models.market.createMarket
import models.outcome.createOutcome
import outcome

data class Message (
    val header: Header,
    val body: Body?,
)

fun createMessage(lines: List<String>): Message {
    return Message(
        header = createHeader(lines),
        body = when (lines[Header.Position.type]) {
            outcome -> createOutcome(lines)
            event -> createEvent(lines)
            market -> createMarket(lines)
            else -> {
                // would like to add logging here
                println("unknown type ${lines[Header.Position.type]}")
                null
            }
        }
    )
}
