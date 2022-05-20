package models.outcome

import boolean.numberToBoolean
import models.body.Body
data class Outcome(
    val marketId: String,
    val outcomeId: String,
    val price: String,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
): Body {
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
