package cache

class Cache() {
    private val store: Map<String, String> = mutableMapOf()

    fun add(marketId: String, eventId: String ) = store.plus(mapOf(marketId to eventId))

    fun lookup(marketId: String): String = try {
        println("success for $marketId")
        checkNotNull(store[marketId])
    } catch (e: Exception) {
//        println("no event for $marketId")
        "no-key"
    }
}
