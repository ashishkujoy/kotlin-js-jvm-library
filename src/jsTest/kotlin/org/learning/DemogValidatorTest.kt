package org.learning

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import org.learning.domain.Address

class DemogValidatorTest : StringSpec({
    "an address without special char should be valid" {
        DemogValidator().isValidAddress(
            Address(
                lineOne = "line one",
                lineTwo = "line two"
            )
        ).shouldBeTrue()
    }

    "an address with 6 special char in line one should not be valid" {
        DemogValidator().isValidAddress(
            Address(
                lineOne = "@l#i:n<e>/\\@# one",
                lineTwo = "line two"
            )
        ).shouldBeFalse()
    }

    "an address with 6 special char in line two should not be valid" {
        DemogValidator().isValidAddress(
            Address(
                lineOne = "@line one",
                lineTwo = "@l#i:n<e>/\\@# @two"
            )
        ).shouldBeFalse()
    }

})