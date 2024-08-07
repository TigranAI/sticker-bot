package ru.tigran.stickerbot.processor.handler.impl

import org.springframework.stereotype.Component
import ru.tigran.stickerbot.processor.handler.MessageHandler
import ru.tigran.stickerbot.repository.InMemoryChatMessages
import ru.tigran.telegram.bots.api.TelegramAsyncClient
import ru.tigran.telegram.bots.api.model.dto.Message
import ru.tigran.telegram.bots.api.model.request.DeleteMessagesRequest

@Component
class ClearCommandHandler(
    private val chatMessages: InMemoryChatMessages,
    private val telegramClient: TelegramAsyncClient,
) : MessageHandler(chatMessages) {
    override fun isSuitable(message: Message) = message is Message.FullMessage && message.text == "/clear"

    override suspend fun handle(message: Message) {
        chatMessages.pop(message.chat.id).chunked(100).forEach {
            telegramClient.deleteMessages(DeleteMessagesRequest(
                message.chat.id.toString(),
                messageIds = it
            ))
        }
    }
}
