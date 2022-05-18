import models.body.Body
import models.header.Header
import models.event.Event
import models.message.Message
import models.outcome.Outcome
import strings.splitByPipe

const val market = "models/market"
const val outcome = "models"
const val event = "models/event"

fun main(args: Array<String>) {
    val socket = java.net.Socket("localhost", 8282)
    val reader = socket.getInputStream().bufferedReader()
    for (line in reader.lines()) {
        val sanitisedList = line.splitByPipe()
        println(sanitisedList)
        // create header


//        when(header.type) {
//            market -> Market(sanitisedList[4].toUUID())
//            outcome -> Outcome()
//            event -> Event()
//        }

        // process event type

        // parse into json
    }
}

// 1 refactor this into a package
// 2 write some unit tests based on the data in -> List<String> out -> Message data class


fun createMessage(lines: List<String>): Message {
    return Message(
        header = Header(msgId = 0, operation = "", type = "", timeStamp = 0),
        body = Outcome(marketId = "", outcomeId = "", name = "", price = "", displayed = false, suspended = false),
    )
}
