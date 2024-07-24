package ru.tigran.sticker_bot.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.tigran.sticker_bot.telegram.configuration.TelegramApiConfiguration
import ru.tigran.sticker_bot.telegram.configuration.TelegramPollerConfiguration

@Configuration
@Import(
    TelegramApiConfiguration::class,
    TelegramPollerConfiguration::class,
)
class StickerBotConfiguration