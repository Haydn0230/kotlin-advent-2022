package Header

data class Header(
    val msgId: Int,
    val operation: String,
    val type: String,
    val timeStamp: Long,
) {
    fun Parser() {

    }
}

