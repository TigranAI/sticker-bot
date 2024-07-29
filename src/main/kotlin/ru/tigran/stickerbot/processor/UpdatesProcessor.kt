package ru.tigran.stickerbot.processor

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import ru.tigran.telegram.bots.api.model.dto.Update
import ru.tigran.telegram.bots.polling.TelegramUpdateProcessor

private val log = KotlinLogging.logger {  }

@Component
class UpdatesProcessor : TelegramUpdateProcessor {
    override suspend fun process(update: Update) {
        log.info { "Got update $update" }
    }
}