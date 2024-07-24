package ru.tigran.sticker_bot.telegram.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import ru.tigran.sticker_bot.telegram.api.model.response.User
import ru.tigran.sticker_bot.telegram.api.properties.TelegramClientProperties

@Service
class TelegramApiService(
    private val telegramClientProperties: TelegramClientProperties,
) {
    private val api: TelegramApi by lazy { createApiClient() }

    suspend fun getMe(): User = api.getMe(telegramClientProperties.token).unwrap()

    private fun createApiClient(): TelegramApi {
        val objectMapper = jacksonObjectMapper()
            .registerKotlinModule()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        val jackson = JacksonConverterFactory.create(objectMapper)

        val retrofit = Retrofit.Builder()
            .baseUrl(telegramClientProperties.host)
            .addConverterFactory(jackson)
            .build()
        return retrofit.create(TelegramApi::class.java)
    }
}