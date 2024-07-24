package ru.tigran.sticker_bot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.tigran.sticker_bot.telegram.api.TelegramApiService
import ru.tigran.sticker_bot.telegram.api.model.response.User

@RestController
class HelloWorld(
    private val telegramApiService: TelegramApiService,
) {
    @GetMapping("/hello-world")
    suspend fun helloWorld(): String {
        return "Hello world"
    }

    @GetMapping("/me")
    suspend fun getMe(): User {
        return telegramApiService.getMe()
    }
}