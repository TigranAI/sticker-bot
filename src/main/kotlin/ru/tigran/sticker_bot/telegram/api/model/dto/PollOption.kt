package ru.tigran.sticker_bot.telegram.api.model.dto

data class PollOption(
    val text: String,
    val textEntities: List<MessageEntity>?,
    val voterCount: Int,
)
