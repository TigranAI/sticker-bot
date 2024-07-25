package ru.tigran.sticker_bot.telegram.api.model.dto

data class LoginUrl(
    val url: String,
    val forwardText: String?,
    val botUsername: String?,
    val requestWriteAccess: Boolean?,
)
