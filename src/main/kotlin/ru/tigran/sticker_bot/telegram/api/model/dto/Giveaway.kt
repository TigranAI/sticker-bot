package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.CountryCode

data class Giveaway(
    val chats: List<Chat>,
    val winnersSelectionDate: Long,
    val winnerCount: Int,
    val onlyNewMembers: Boolean?,
    val hasPublicWinners: Boolean?,
    val prizeDescription: String?,
    val countryCodes: List<CountryCode>?,
    val premiumSubscriptionMonthCount: Int?,
)
