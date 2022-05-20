package com.feedme.models


enum class Type {
    MARKET, OUTCOME, EVENT;
    override fun toString(): String = name.toLowerCase()
}

data class Message(
    val header: Header,
    val body: Body?,
)

fun createMessage(lines: List<String>): Message {
    return Message(
        header = createHeader(lines),
        body = when (lines[Header.Position.type]) {
            Type.OUTCOME.toString() -> createOutcome(lines)
            Type.EVENT.toString() -> createEvent(lines)
            Type.MARKET.toString()-> createMarket(lines)
            else -> {
                // would like to add logging here
                println("unknown type ${lines[Header.Position.type]}")
                null
            }
        }
    )
}
