package ru.tigran.sticker_bot.telegram.configuration.poller

import org.springframework.boot.context.properties.ConfigurationProperties
import kotlin.time.Duration

@ConfigurationProperties(prefix = "telegram.poller")
data class TelegramPollerProperties(
    val delay: String,
    val timeout: String,
    val limit: Int = 100,
) {
    val delayDuration
        get() = Duration.parse(delay)
    val timeoutDuration
        get() = Duration.parse(delay)
}