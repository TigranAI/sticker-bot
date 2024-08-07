package ru.tigran.stickerbot.processor

import org.springframework.stereotype.Component
import ru.tigran.stickerbot.processor.handler.MessageHandler
import ru.tigran.stickerbot.processor.handler.UpdateHandler
import ru.tigran.telegram.bots.api.model.dto.Update

@Component
class UpdateRouter(
    private val messageHandlers: List<MessageHandler>,
) {
    fun route(update: Update): UpdateHandler = when(update) {
        is Update.MessageUpdate -> messageHandlers.first { it.isSuitable(update) }
        else -> throw UnsupportedOperationException("Unknown update type. id=${update.updateId}")
    }
}
