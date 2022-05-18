package models.outcome

import models.body.Body
data class Outcome(
    val marketId: String,
    val outcomeId: String,
    val price: String,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
): Body
