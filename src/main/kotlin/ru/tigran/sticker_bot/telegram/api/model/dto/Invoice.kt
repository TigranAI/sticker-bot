package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.Currency

data class Invoice(
    val title: String,
    val description: String,
    val startParameter: String,
    val currency: Currency,
    val totalAmount: Int,
)
