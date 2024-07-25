package ru.tigran.sticker_bot.telegram.api.model.dto

data class LinkPreviewOptions(
    val isDisabled: Boolean?,
    val url: String?,
    val preferSmallMedia: Boolean?,
    val preferLargeMedia: Boolean?,
    val showAboveText: Boolean?,
)
