package ru.tigran.sticker_bot.telegram.api.model.dto

data class Contact(
    val phoneNumber: String,
    val firstName: String,
    val lastName: String?,
    val userId: Long?,
    val vcard: String?,
)
