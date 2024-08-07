package ru.tigran.stickerbot.processor

import org.springframework.stereotype.Component
import ru.tigran.telegram.bots.api.model.dto.Update
import ru.tigran.telegram.bots.polling.TelegramUpdateProcessor

@Component
class UpdatesProcessor(
    private val updateRouter: UpdateRouter,
) : TelegramUpdateProcessor {
    override suspend fun process(update: Update) {
        updateRouter.route(update).handle(update)
    }
}
