package ru.tigran.stickerbot.repository

import org.springframework.stereotype.Component

@Component
class InMemoryChatMessages(
    private val messagesByChatId: HashMap<Long, ArrayList<Long>>
) {
    fun put(chatId: Long, messageId: Long) {
        if (!messagesByChatId.containsKey(chatId)) {
            messagesByChatId[chatId] = ArrayList()
        }
        messagesByChatId[chatId]!!.add(messageId)
    }

    fun pop(chatId: Long): List<Long> {
        val messages = messagesByChatId[chatId] ?: listOf()
        messagesByChatId[chatId] = ArrayList()
        return messages
    }
}