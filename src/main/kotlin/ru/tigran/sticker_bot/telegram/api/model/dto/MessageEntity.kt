package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.MessageEntityType

data class MessageEntity(
    val type: MessageEntityType,
    val offset: Long,
    val length: Long,
    val url: String?,
    val user: User?,
    val language: String?,
    val customEmojiId: String?,
)
