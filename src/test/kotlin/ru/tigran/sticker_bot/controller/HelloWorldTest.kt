package ru.tigran.sticker_bot.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.reactive.server.WebTestClient
import ru.tigran.sticker_bot.BaseTest

class HelloWorldTest @Autowired constructor (
    private val webClient: WebTestClient,
) : BaseTest() {
    @Test
    fun testHelloWorld() {
        webClient.get().uri("/hello-world")
            .exchange()
            .expectStatus().isOk
    }
}