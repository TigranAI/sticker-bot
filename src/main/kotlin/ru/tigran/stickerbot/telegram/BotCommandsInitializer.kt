package ru.tigran.stickerbot.telegram

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import ru.tigran.telegram.bots.api.TelegramAsyncClient
import ru.tigran.telegram.bots.api.model.dto.BotCommand
import ru.tigran.telegram.bots.api.model.dto.BotCommandScope
import ru.tigran.telegram.bots.api.model.enums.CountryCode
import ru.tigran.telegram.bots.api.model.request.SetMyCommandsRequest

@Component
class BotCommandsInitializer(
    private val telegramClient: TelegramAsyncClient,
) {
    @EventListener(ApplicationReadyEvent::class)
    suspend fun initializeBotCommands() {
        telegramClient.setMyCommands(SetMyCommandsRequest(
            commands = listOf(
                BotCommand("/start", "Запустить бота"),
            ),
            languageCode = CountryCode.RU,
            scope = BotCommandScope.BotCommandScopeDefault(),
        ))
        telegramClient.setMyCommands(SetMyCommandsRequest(
            commands = listOf(
                BotCommand("/clear", "Очистить чат"),
            ),
            languageCode = CountryCode.RU,
            scope = BotCommandScope.BotCommandScopeAllChatAdministrators(),
        ))
    }
}