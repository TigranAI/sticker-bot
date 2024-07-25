package ru.tigran.sticker_bot.telegram.api.model.dto

data class PassportData(
    val data: List<EncryptedPassportElement>,
    val credentials: EncryptedCredentials,
)
