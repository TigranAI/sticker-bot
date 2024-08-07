package ru.tigran.stickerbot.telegram

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import ru.tigran.stickerbot.repository.InMemoryChatMessages
import ru.tigran.telegram.bots.api.TelegramAsyncClient
import ru.tigran.telegram.bots.api.TelegramBotApi
import ru.tigran.telegram.bots.api.model.dto.Message
import ru.tigran.telegram.bots.api.model.request.SendMessageRequest

@Primary
@Component
class TelegramClientDecorator(
    api: TelegramBotApi,
    private val inMemoryChatMessages: InMemoryChatMessages,
) : TelegramAsyncClient(api) {
    override suspend fun sendMessage(message: SendMessageRequest): Message {
        val result = super.sendMessage(message)
        inMemoryChatMessages.put(result.chat.id, result.messageId)
        return result
    }
}