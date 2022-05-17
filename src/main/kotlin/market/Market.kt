package market

import java.util.UUID

data class market(
    val eventId: UUID,
    val marketId: UUID,
    val name: String,
    val displayed: Boolean,
    val suspended: Boolean,
)
