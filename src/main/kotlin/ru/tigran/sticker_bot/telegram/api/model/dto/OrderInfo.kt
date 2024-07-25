package ru.tigran.sticker_bot.telegram.api.model.dto

data class OrderInfo(
    val name: String?,
    val phoneNumber: String?,
    val email: String?,
    val shippingAddress: ShippingAddress?,
)
