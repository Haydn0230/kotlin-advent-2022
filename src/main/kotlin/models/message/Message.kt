package models.message

import models.header.Header
import models.body.Body

data class Message (
    val header: Header,
    val body: Body?,
)
