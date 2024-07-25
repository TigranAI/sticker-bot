package ru.tigran.sticker_bot.telegram.api.model.dto

import ru.tigran.sticker_bot.telegram.api.model.enums.Currency

data class RefundedPayment(
    val currency: Currency,
    val totalAmount: Int,
    val invoicePayload: String,
    val telegramPaymentChargeId: String,
    val providerPaymentChargeId: String?,
)
