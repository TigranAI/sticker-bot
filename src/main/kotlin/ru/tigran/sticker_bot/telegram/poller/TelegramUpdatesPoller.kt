package ru.tigran.sticker_bot.telegram.poller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import ru.tigran.sticker_bot.telegram.api.TelegramAsyncClient
import ru.tigran.sticker_bot.telegram.api.model.request.GetUpdatesRequest
import ru.tigran.sticker_bot.telegram.configuration.poller.TelegramPollerProperties
import ru.tigran.sticker_bot.util.ScheduledAsyncJob

private val log = KotlinLogging.logger {  }

@Component
class TelegramUpdatesPoller(
    private val properties: TelegramPollerProperties,
    private val telegramClient: TelegramAsyncClient,
) : ScheduledAsyncJob(delay = properties.delayDuration) {
    private var offset: Long? = null

    init {
        log.info { "Initialize update poller, delay is ${properties.delay}" }
    }

    override suspend fun execute() {
        val updates = telegramClient.getUpdates(
            GetUpdatesRequest(
                offset = offset,
                limit = properties.limit,
                timeout = properties.timeoutDuration.inWholeSeconds.toInt(),
            )
        )
        updates.lastOrNull()?.let { offset = it.updateId + 1 }
        log.info { updates }
    }
}