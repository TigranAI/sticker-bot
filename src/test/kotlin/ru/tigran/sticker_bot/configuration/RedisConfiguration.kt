package ru.tigran.sticker_bot.configuration

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.GenericContainer

private val redis = GenericContainer("redis:latest").withExposedPorts(6379)

@DynamicPropertySource
private fun addRedis(registry: DynamicPropertyRegistry) {
    registry.add("spring.redis.host", redis::getHost)
    registry.add("spring.redis.host", redis::getFirstMappedPort)
}