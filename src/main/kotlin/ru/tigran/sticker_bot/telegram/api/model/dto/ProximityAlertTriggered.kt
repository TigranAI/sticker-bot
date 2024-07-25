package ru.tigran.sticker_bot.telegram.api.model.dto

data class ProximityAlertTriggered(
    val traveler: User,
    val watcher: User,
    val distance: Int,
)
