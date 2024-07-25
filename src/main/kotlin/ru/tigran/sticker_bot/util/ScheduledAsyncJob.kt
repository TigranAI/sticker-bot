package ru.tigran.sticker_bot.util

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration

abstract class ScheduledAsyncJob(
    private val delay: Duration,
    private val job: Job = Job()
) : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Default + job

    init {
        start()
    }

    fun start() = launch {
        while (true) {
            execute()
            delay(delay)
        }
    }

    abstract suspend fun execute()
    fun stop() = job.cancel()
}