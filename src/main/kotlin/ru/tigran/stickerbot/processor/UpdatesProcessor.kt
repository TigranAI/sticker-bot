package ru.tigran.stickerbot.processor

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import ru.tigran.telegram.bots.api.TelegramAsyncClient
import ru.tigran.telegram.bots.api.model.dto.InlineKeyboardButton
import ru.tigran.telegram.bots.api.model.dto.Message
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.Update
import ru.tigran.telegram.bots.api.model.enums.ParseModeType
import ru.tigran.telegram.bots.api.model.request.SendMessageRequest
import ru.tigran.telegram.bots.polling.TelegramUpdateProcessor

private val log = KotlinLogging.logger {  }

@Component
class UpdatesProcessor(
    private val telegramAsyncClient: TelegramAsyncClient,
) : TelegramUpdateProcessor {
    override suspend fun process(update: Update) {
        when(update) {
            is Update.BusinessConnectionUpdate -> TODO()
            is Update.BusinessMessageUpdate -> TODO()
            is Update.CallbackQueryUpdate -> processCallbackQuery(update)
            is Update.ChannelPostUpdate -> TODO()
            is Update.ChatBoostUpdate -> TODO()
            is Update.ChatJoinRequestUpdate -> TODO()
            is Update.ChatMemberUpdate -> TODO()
            is Update.ChosenInlineResultUpdate -> TODO()
            is Update.DeletedBusinessMessagesUpdate -> TODO()
            is Update.EditedBusinessMessageUpdate -> TODO()
            is Update.EditedChannelPostUpdate -> TODO()
            is Update.EditedMessageUpdate -> TODO()
            is Update.InlineQueryUpdate -> TODO()
            is Update.MessageReactionCountUpdate -> TODO()
            is Update.MessageReactionUpdate -> TODO()
            is Update.MessageUpdate -> processMessage(update)
            is Update.MyChatMemberUpdate -> TODO()
            is Update.PollAnswerUpdate -> TODO()
            is Update.PollUpdate -> TODO()
            is Update.PreCheckoutQueryUpdate -> TODO()
            is Update.RemovedChatBoostUpdate -> TODO()
            is Update.ShippingQueryUpdate -> TODO()
            else -> { }
        }
    }

    private fun processCallbackQuery(update: Update.CallbackQueryUpdate) {
        log.info { "Received callback ${update.callbackQuery.data}" }
    }

    suspend fun processMessage(update: Update.MessageUpdate) {
        val chatId = update.message.chat.id
        val text = when (update.message) {
            is Message.FullMessage -> (update.message as Message.FullMessage).text
            else -> ""
        }
        telegramAsyncClient.sendMessage(SendMessageRequest(
            chatId = chatId.toString(),
            text = """
                |I Received
                |>$text
            """.trimMargin(),
            parseMode = ParseModeType.MarkdownV2,
            replyMarkup = ReplyMarkup.InlineKeyboardMarkup(
                inlineKeyboard = listOf(
                    listOf(
                        InlineKeyboardButton(text = "hello", callbackData = "callback")
                    )
                )
            )
        ))
    }
}