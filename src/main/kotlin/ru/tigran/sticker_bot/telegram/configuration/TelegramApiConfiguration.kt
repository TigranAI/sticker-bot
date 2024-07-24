package ru.tigran.sticker_bot.telegram.configuration

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import ru.tigran.sticker_bot.telegram.api.properties.TelegramClientProperties

@Configuration
@ComponentScan(
    "ru.tigran.sticker_bot.telegram"
)
@EnableConfigurationProperties(
    TelegramClientProperties::class
)
class TelegramApiConfiguration