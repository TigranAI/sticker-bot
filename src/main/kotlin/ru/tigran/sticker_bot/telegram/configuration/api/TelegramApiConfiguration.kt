package ru.tigran.sticker_bot.telegram.configuration.api

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("ru.tigran.sticker_bot.telegram.api")
@EnableConfigurationProperties(TelegramApiProperties::class)
class TelegramApiConfiguration
