package ru.xpendence.exposed.domain

import java.util.UUID

data class Restaurant(
    val id: UUID? = null,
    var name: String
)
