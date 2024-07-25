package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.ChatType

data class Chat(
    val id: Long,
    val type: ChatType,
    val title: String?,
    val username: String?,
    val firstName: String?,
    val lastName: String?,
    val isForum: Boolean?,
)
