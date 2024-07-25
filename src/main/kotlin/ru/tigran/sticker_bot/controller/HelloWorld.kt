package ru.tigran.sticker_bot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.tigran.sticker_bot.telegram.api.TelegramAsyncClient
import ru.tigran.sticker_bot.telegram.api.model.dto.User

@RestController
class HelloWorld(
    private val telegramClient: TelegramAsyncClient,
) {
    @GetMapping("/hello-world")
    suspend fun helloWorld(): String {
        return "Hello world"
    }

    @GetMapping("/me")
    suspend fun getMe(): User {
        return telegramClient.getMe()
    }
}