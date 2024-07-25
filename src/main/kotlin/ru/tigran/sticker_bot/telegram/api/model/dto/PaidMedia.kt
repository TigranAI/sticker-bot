package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.PaidMediaType

data class PaidMedia(
    val type: PaidMediaType,
    val width: Int?,
    val height: Int?,
    val duration: Int?,
    val photo: List<PhotoSize>?,
    val video: Video?,
)
