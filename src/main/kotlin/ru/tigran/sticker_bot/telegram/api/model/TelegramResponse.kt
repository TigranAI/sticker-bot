package ru.tigran.sticker_bot.telegram.api.model

import ru.tigran.sticker_bot.telegram.api.model.exception.TelegramClientException

data class TelegramResponse<T>(
    val ok: Boolean,
    val result: T?,
    val errorCode: Int?,
    val description: String?,
) {
    fun unwrap(): T {
        if (ok) return result!!
        throw TelegramClientException(errorCode!!, description!!)
    }
}