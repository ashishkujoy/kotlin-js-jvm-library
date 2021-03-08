package org.learning

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ResourceReaderTest : StringSpec({
    "read test file in jvm" {
        readResource("testfile.txt") shouldBe "this is a test file"
    }
})