package ru.tigran.stickerbot.processor.handler.impl

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import ru.tigran.stickerbot.processor.handler.MessageHandler
import ru.tigran.stickerbot.repository.InMemoryChatMessages
import ru.tigran.telegram.bots.api.TelegramAsyncClient
import ru.tigran.telegram.bots.api.model.dto.Message
import ru.tigran.telegram.bots.api.model.request.DeleteMessagesRequest

private val log = KotlinLogging.logger {  }

@Component
class ClearCommandHandler(
    private val chatMessages: InMemoryChatMessages,
    private val telegramAsyncClient: TelegramAsyncClient,
) : MessageHandler(chatMessages) {
    override fun isSuitable(message: Message) = message is Message.FullMessage && message.text == "/clear"

    override suspend fun handle(message: Message) {
        val messages = chatMessages.pop(message.chat.id)
        log.info { "Deleting messages $messages" }
        telegramAsyncClient.deleteMessages(DeleteMessagesRequest(
            message.chat.id.toString(),
            messageIds = messages
        ))
    }
}
