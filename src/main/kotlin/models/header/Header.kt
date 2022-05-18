package models.header

data class Header(
    val msgId: Int,
    val operation: String,
    val type: String,
    val timeStamp: Long,
) {
    fun Parser(list: List<String>): Header {
        val newHeader: Header
        return try {
            newHeader = Header(
                msgId = list[0].toInt(),
                operation = list[1],
                type = list[2],
                timeStamp = list[3].toLong()
            )
            newHeader
        } catch (e: Exception) {
            println("failed to instantiate header ${e.message}")
            return Header(0, "", "", 0 )
        }
    }
}

