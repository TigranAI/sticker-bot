package ru.tigran.sticker_bot.telegram.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import ru.tigran.sticker_bot.telegram.api.model.TelegramResponse
import ru.tigran.sticker_bot.telegram.api.model.dto.Update
import ru.tigran.sticker_bot.telegram.api.model.dto.User

interface TelegramBotApi {
    @GET("/bot{token}/getMe")
    suspend fun getMe(
        @Path("token") token: String,
    ): TelegramResponse<User>

    @GET("/bot{token}/getUpdates")
    suspend fun getUpdates(
        @Path("token") token: String,
        @QueryMap params: Map<String, String>,
    ): TelegramResponse<List<Update>>
}