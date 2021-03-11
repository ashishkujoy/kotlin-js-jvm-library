package org.learning

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PingTest: StringSpec({
  "ping should return Pong" {
      ping() shouldBe "Pong"
  }
})