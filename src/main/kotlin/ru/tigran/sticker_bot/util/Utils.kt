package ru.tigran.sticker_bot.util

fun <K, V> mapOfNotNullValues(vararg pairs: Pair<K, V?>): Map<K, V> = pairs.asSequence()
    .filter { it.second != null }
    .map { it.first to it.second!! }
    .toMap()