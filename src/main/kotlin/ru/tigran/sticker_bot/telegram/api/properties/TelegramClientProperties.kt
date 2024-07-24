package ru.tigran.sticker_bot.telegram.api.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("telegram")
open class TelegramClientProperties(
    val host: String,
    val token: String
)