package ru.tigran.sticker_bot.telegram.api.model.dto

data class GiveawayCompleted(
    val winnerCount: Int,
    val unclaimedPrizeCount: Int?,
    val giveawayMessage: Message?,
)
