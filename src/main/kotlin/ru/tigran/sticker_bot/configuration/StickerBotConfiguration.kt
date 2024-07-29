package ru.tigran.sticker_bot.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import ru.tigran.sticker_bot.util.Profiles
import ru.tigran.telegram.bots.configuration.api.TelegramApiConfiguration
import ru.tigran.telegram.bots.configuration.polling.TelegramPollerConfiguration

@Configuration
@Import(
    TelegramApiConfiguration::class,
    TelegramPollerConfiguration::class,
)
@Profile("!${Profiles.TESTS}")
class StickerBotConfiguration
