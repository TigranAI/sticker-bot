package ru.tigran.sticker_bot.telegram.api.model.exception

import org.springframework.http.HttpStatusCode
import org.springframework.web.client.HttpStatusCodeException

class TelegramClientException(
    errorCode: Int,
    description: String,
) : HttpStatusCodeException(HttpStatusCode.valueOf(errorCode), description)
