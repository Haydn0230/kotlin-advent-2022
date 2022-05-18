package models.event

import models.body.Body

data class Event (
    val eventId: String,
    val category: String,
    val subCategory: String,
    val startTime: Long,
    override val name: String,
    override val displayed: Boolean,
    override val suspended: Boolean,
): Body
