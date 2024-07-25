package ru.tigran.sticker_bot.telegram.api.model.dto

data class UsersShared(
    val requestId: Long,
    val users: List<SharedUser>,
)
