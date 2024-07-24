package ru.tigran.sticker_bot.telegram.api

import retrofit2.http.GET
import retrofit2.http.Path
import ru.tigran.sticker_bot.telegram.api.model.response.TelegramResponse
import ru.tigran.sticker_bot.telegram.api.model.response.User

interface TelegramApi {
    @GET("/bot{token}/getMe")
    suspend fun getMe(
        @Path("token") token: String,
    ): TelegramResponse<User>
}