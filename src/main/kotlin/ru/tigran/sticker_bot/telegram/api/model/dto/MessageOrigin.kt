package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.MessageOriginType

data class MessageOrigin(
    val type: MessageOriginType,
    val date: Long,
    val senderUser: User?,
    val senderUserName: String?,
    val senderChat: Chat?,
    val authorSignature: String?,
    val messageId: Long?,
)