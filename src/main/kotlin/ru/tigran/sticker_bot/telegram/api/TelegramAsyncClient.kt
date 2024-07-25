package ru.tigran.sticker_bot.telegram.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.cfg.EnumFeature
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import ru.tigran.sticker_bot.telegram.api.model.dto.Update
import ru.tigran.sticker_bot.telegram.api.model.dto.User
import ru.tigran.sticker_bot.telegram.api.model.request.GetUpdatesRequest
import ru.tigran.sticker_bot.telegram.configuration.api.TelegramApiProperties

@Service
class TelegramAsyncClient(
    private val properties: TelegramApiProperties,
) {
    private val api: TelegramBotApi by lazy { createApiClient() }

    suspend fun getMe(): User = api.getMe(properties.token).unwrap()

    suspend fun getUpdates(
        request: GetUpdatesRequest,
    ): List<Update> = api.getUpdates(properties.token, request.asRequestMap()).unwrap()

    private fun createApiClient(): TelegramBotApi {
        val jackson = JacksonConverterFactory.create(telegramApiCompatibleJacksonObjectMapper)
        val retrofit = Retrofit.Builder()
            .baseUrl(properties.host)
            .addConverterFactory(jackson)
            .build()
        return retrofit.create(TelegramBotApi::class.java)
    }
}

private val telegramApiCompatibleJacksonObjectMapper = Jackson2ObjectMapperBuilder.json()
        .modules(kotlinModule())
        .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
        .featuresToEnable(
            MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS,
            EnumFeature.WRITE_ENUMS_TO_LOWERCASE,
        )
        .featuresToDisable(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
        )
        .build<ObjectMapper>()