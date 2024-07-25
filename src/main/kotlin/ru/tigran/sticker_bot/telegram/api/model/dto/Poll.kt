package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.PollType

data class Poll(
    val id: String,
    val question: String,
    val questionEntities: List<MessageEntity>?,
    val options: List<PollOption>,
    val totalVoterCount: Int,
    val isClosed: Boolean,
    val isAnonymous: Boolean,
    val type: PollType,
    val allowMultipleAnswers: Boolean,
    val correctOptionId: Int?,
    val explanation: String?,
    val explanationEntities: List<MessageEntity>?,
    val openPeriod: Int?,
    val closeDate: Long?,
)
