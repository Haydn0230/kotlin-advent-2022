package models.market

import models.body.Body
data class Market(
    val eventId: String,
    val marketId: String,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
) : Body
