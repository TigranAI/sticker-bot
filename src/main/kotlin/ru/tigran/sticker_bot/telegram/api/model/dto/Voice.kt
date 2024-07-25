package ru.tigran.sticker_bot.telegram.api.model.dto

data class Voice(
    val fileId: String,
    val fileUniqueId: String,
    val duration: Int,
    val mimeType: String?,
    val fileSize: Long?,
)
