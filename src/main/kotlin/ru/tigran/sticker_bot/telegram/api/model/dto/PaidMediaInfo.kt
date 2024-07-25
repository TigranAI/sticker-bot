package ru.tigran.sticker_bot.telegram.api.model.dto

data class PaidMediaInfo(
    val starCount: Int,
    val paidMedia: List<PaidMedia>,
)
