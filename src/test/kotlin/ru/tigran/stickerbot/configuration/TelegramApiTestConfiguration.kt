package ru.tigran.stickerbot.configuration

import io.mockk.coEvery
import io.mockk.mockk
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.tigran.telegram.bots.api.TelegramBotApi
import ru.tigran.telegram.bots.api.model.TelegramResponse

@Configuration
class TelegramApiTestConfiguration {
    @Bean
    fun telegramBotApi(): TelegramBotApi {
        val mock = mockk<TelegramBotApi>()
        coEvery { mock.getUpdates(any(), any()) } returns TelegramResponse(true, emptyList(), null, null)
        return mock
    }
}