package ru.tigran.sticker_bot.telegram.api.model.dto

data class TextQuote(
    val text: String,
    val entities: List<MessageEntity>?,
    val position: Long,
    val isManual: Boolean?,
)
