package ru.tigran.stickerbot.configuration

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan(
    basePackages = ["ru.tigran.sticker_bot"],
)
@Import(
    TelegramApiTestConfiguration::class,
)
class StickerBotTestConfiguration
