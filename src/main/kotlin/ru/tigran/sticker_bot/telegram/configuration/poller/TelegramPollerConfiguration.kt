package ru.tigran.sticker_bot.telegram.configuration.poller

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("ru.tigran.sticker_bot.telegram.poller")
@EnableConfigurationProperties(TelegramPollerProperties::class)
class TelegramPollerConfiguration
