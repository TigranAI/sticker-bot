package ru.tigran.sticker_bot.telegram.api.model.dto

data class Location(
    val latitude: Float,
    val longitude: Float,
    val horizontalAccuracy: Float?,
    val livePeriod: Int?,
    val heading: Int?,
    val proximityAlertRadius: Int?,
)
