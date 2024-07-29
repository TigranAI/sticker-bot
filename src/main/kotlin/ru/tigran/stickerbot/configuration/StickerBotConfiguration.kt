package ru.tigran.stickerbot.configuration

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import ru.tigran.stickerbot.util.Profiles
import ru.tigran.telegram.bots.configuration.api.TelegramApiConfiguration
import ru.tigran.telegram.bots.configuration.polling.TelegramPollerConfiguration

@Configuration
@Import(
    TelegramApiConfiguration::class,
    TelegramPollerConfiguration::class,
)
@Profile("!${Profiles.TESTS}")
@ComponentScan(
    "ru.tigran.stickerbot.processor",
    "ru.tigran.stickerbot.repository",
)
class StickerBotConfiguration
