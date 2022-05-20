package com.feedme.cache

class Cache {
    private val store: Map<String, String> = mapOf()

    fun add(marketId: String, eventId: String) = store.plus(mapOf(marketId to eventId))

    fun lookup(marketId: String): String = store.getOrDefault(marketId, "no-key")
}
