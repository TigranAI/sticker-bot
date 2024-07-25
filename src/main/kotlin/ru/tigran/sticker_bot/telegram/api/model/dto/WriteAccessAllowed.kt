package ru.tigran.sticker_bot.telegram.api.model.dto

data class WriteAccessAllowed(
    val fromRequest: Boolean?,
    val webAppName: String?,
    val fromAttachmentMenu: Boolean?,
)
