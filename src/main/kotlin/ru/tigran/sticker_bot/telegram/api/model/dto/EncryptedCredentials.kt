package ru.tigran.sticker_bot.telegram.api.model.dto

data class EncryptedCredentials(
    val data: String,
    val hash: String,
    val secret: String,
)
