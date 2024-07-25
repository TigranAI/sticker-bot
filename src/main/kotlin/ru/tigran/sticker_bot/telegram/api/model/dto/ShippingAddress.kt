package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.CountryCode

data class ShippingAddress(
    val countryCode: CountryCode,
    val state: String,
    val city: String,
    val streetLine1: String,
    val streetLine2: String,
    val postCode: String,
)
