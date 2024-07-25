package ru.tigran.sticker_bot.telegram.api.model.dto

data class SharedUser(
    val userId: Long,
    val firstName: String?,
    val lastName: String?,
    val username: String?,
    val photo: List<PhotoSize>?,
)
