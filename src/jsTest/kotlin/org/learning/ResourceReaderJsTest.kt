package org.learning

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ResourceReaderJsTest: StringSpec({
  "should read file in js platform" {
      readResource("../../../../testfile.txt") shouldBe "this is a test file"
  }
})