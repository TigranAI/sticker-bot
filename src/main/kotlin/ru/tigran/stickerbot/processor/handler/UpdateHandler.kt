package ru.tigran.stickerbot.processor.handler

import ru.tigran.telegram.bots.api.model.dto.Update

interface UpdateHandler {
    fun isSuitable(update: Update): Boolean
    suspend fun handle(update: Update)
}