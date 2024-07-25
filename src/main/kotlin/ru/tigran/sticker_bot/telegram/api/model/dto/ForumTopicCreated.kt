package ru.tigran.sticker_bot.telegram.api.model.dto

data class ForumTopicCreated(
    val name: String,
    val iconColor: Int,
    val iconCustomEmojiId: String?,
)
