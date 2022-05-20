
import cache.Cache
import models.event.Event
import models.event.createEvent
import models.header.Header
import models.header.createHeader
import models.market.Market
import models.market.createMarket
import models.message.Message
import models.outcome.Outcome
import models.outcome.createOutcome
import producer.Producer
import strings.splitByPipe


const val market = "market"
const val outcome = "outcome"
const val event = "event"

fun main(args: Array<String>) {
    val socket = java.net.Socket("localhost", 8282)
    val reader = socket.getInputStream().bufferedReader()
    val producer = Producer().createProducer("localhost:9092")
    val eventStore = Cache()
    for (line in reader.lines()) {
        val sanitisedList = line.splitByPipe()
        val message = createMessage(sanitisedList)
        var key = String()
        when(message.body) {
            is Event -> { key = message.body.eventId}
            is Market -> {
                eventStore.add(message.body.marketId, message.body.eventId)
                key = message.body.eventId
            }
            is Outcome -> {
                key = eventStore.lookup(message.body.marketId)
            }

        }
       Producer().produce(producer,"dev.betting", key,  message)
    }
}

// 1 refactor this into a package

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
