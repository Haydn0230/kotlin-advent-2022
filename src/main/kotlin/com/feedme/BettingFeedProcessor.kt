package com.feedme

import com.feedme.cache.Cache
import com.feedme.models.createMessage
import com.feedme.models.Event
import com.feedme.models.Market
import com.feedme.models.Message
import com.feedme.models.Outcome
import java.net.Socket

class BettingFeedProcessor {
    private val producer = Producer()
    private val eventStore = Cache()

    fun processBettingFeed() {
        val reader = Socket("localhost", 8282).getInputStream().bufferedReader()
        reader.use {
            it.lines().forEach { line ->
                val message = createMessage(splitByPipe(line))
                producer.produce("dev.betting", message.toKey(), message)
            }
        }
    }

    private fun Message.toKey() =
        when (this.body) {
            is Event -> this.body.eventId
            is Market -> {
                eventStore.add(this.body.marketId, this.body.eventId)
                this.body.eventId
            }
            is Outcome -> eventStore.lookup(this.body.marketId)
            else -> ""
        }
}
