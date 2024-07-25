package ru.tigran.sticker_bot.telegram.api.model.request

import ru.tigran.sticker_bot.telegram.api.model.enums.UpdateType
import ru.tigran.sticker_bot.util.mapOfNotNullValues

data class GetUpdatesRequest(
    val offset: Long? = null,
    val limit: Int? = 100,
    val timeout: Int? = 1500,
    val allowedUpdates: List<UpdateType>? = null,
) {
    fun asRequestMap() = mapOfNotNullValues(
        "offset" to offset?.toString(),
        "limit" to limit?.toString(),
        "timeout" to timeout?.toString(),
        "allowed_updates" to allowedUpdates?.joinToString(",") { it.name.lowercase() },
    )
}