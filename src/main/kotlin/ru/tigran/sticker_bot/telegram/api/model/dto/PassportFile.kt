package ru.tigran.sticker_bot.telegram.api.model.dto

data class PassportFile(
    val fileId: String,
    val fileUniqueId: String,
    val fileSize: Long,
    val fileDate: Long,
)
