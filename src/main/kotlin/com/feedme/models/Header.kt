package com.feedme.models

data class Header(
    val msgId: Int,
    val operation: String,
    val type: String,
    val timeStamp: Long,
) {
    object Position {
        const val msgId = 0
        const val operation = 1
        const val type = 2
        const val timeStamp = 3
    }
}

fun createHeader(lines: List<String>): Header {
    return Header(
        msgId = lines[Header.Position.msgId].toInt(),
        operation = lines[Header.Position.operation],
        type = lines[Header.Position.type],
        timeStamp = lines[Header.Position.timeStamp].toLong()
    )
}

