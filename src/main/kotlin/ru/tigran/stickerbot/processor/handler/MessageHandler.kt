package ru.tigran.stickerbot.processor.handler

import ru.tigran.stickerbot.repository.InMemoryChatMessages
import ru.tigran.telegram.bots.api.model.dto.Message
import ru.tigran.telegram.bots.api.model.dto.Update

abstract class MessageHandler(
    private val chatMessages: InMemoryChatMessages,
) : UpdateHandler {
    protected abstract fun isSuitable(message: Message) : Boolean
    protected abstract suspend fun handle(message: Message)

    override fun isSuitable(update: Update) = update is Update.MessageUpdate && isSuitable(update.message)
    override suspend fun handle(update: Update) {
        val message = (update as Update.MessageUpdate).message
        chatMessages.put(message.chat.id, message.messageId)
        handle(message)
    }
}
