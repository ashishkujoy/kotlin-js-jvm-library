package org.learning

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PingJsTest {
    @Test
    fun shouldReturnPongWithJsTest() {
        ping() shouldBe "Pong"
    }
}