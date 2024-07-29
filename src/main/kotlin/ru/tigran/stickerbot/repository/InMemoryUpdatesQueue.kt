package ru.tigran.stickerbot.repository

import org.springframework.stereotype.Component
import ru.tigran.telegram.bots.api.model.dto.Update
import ru.tigran.telegram.bots.polling.TelegramUpdatesQueue
import java.util.*

@Component
class InMemoryUpdatesQueue : TelegramUpdatesQueue {
    private val queue: Queue<Update> = LinkedList()

    override fun dequeueBatch(size: Int): List<Update> {
        return (0..<size).mapNotNull { queue.poll() }
    }

    override fun enqueueAll(updates: List<Update>) {
        queue.addAll(updates)
    }
}