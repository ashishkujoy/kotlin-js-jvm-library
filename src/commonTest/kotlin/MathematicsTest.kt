import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MathematicsTest : StringSpec({
    val mathematics = Mathematics()

    "should add two numbers" {
        mathematics.add(1, 2) shouldBe 3
    }

    "should subtract two numbers" {
        mathematics.subtract(2, 1) shouldBe 1
    }

    "should multiply two numbers" {
        mathematics.multiply(3, 2) shouldBe 6
    }

    "should divide two numbers" {
        mathematics.divide(6, 2) shouldBe 3
    }
})
