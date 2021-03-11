package org.learning

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PingJsTest: StringSpec({
    "should return pong with js test" {
        ping() shouldBe "Pong"
    }
})