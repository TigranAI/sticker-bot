package ru.tigran.stickerbot.processor.handler.impl

import org.springframework.stereotype.Component
import ru.tigran.stickerbot.processor.handler.MessageHandler
import ru.tigran.stickerbot.repository.InMemoryChatMessages
import ru.tigran.telegram.bots.api.TelegramAsyncClient
import ru.tigran.telegram.bots.api.model.dto.Message
import ru.tigran.telegram.bots.api.model.request.SendMessageRequest

@Component
class StartCommandHandler(
    chatMessages: InMemoryChatMessages,
    private val telegramAsyncClient: TelegramAsyncClient,
) : MessageHandler(chatMessages) {
    override fun isSuitable(message: Message) = message is Message.FullMessage && message.text == "/start"

    override suspend fun handle(message: Message) {
        telegramAsyncClient.sendMessage(SendMessageRequest(
            chatId = message.chat.id.toString(),
            text = "Привет!"
        ))
    }
}
