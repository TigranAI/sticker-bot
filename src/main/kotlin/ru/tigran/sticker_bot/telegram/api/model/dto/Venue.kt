package ru.tigran.sticker_bot.telegram.api.model.dto

data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    val foursquareId: String?,
    val foursquareType: String?,
    val googlePlaceId: String?,
    val googlePlaceType: String?,
)
