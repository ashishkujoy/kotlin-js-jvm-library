package org.learning

import org.learning.domain.Address
import kotlin.js.JsName


class DemogValidator {
    private val specialCharPattern = Regex("[@#^&():;|<>\\-./,{}=_~\\[\\] ]+")
    private val maxAllowedSpecialCharPerLine = 5

    @JsName("isValidAddress")
    fun isValidAddress(address: Address): Boolean {
        val hasValidLineOne = countSpecialCharsIn(address.lineOne) <= maxAllowedSpecialCharPerLine
        val hasValidLineTwo = countSpecialCharsIn(address.lineTwo) <= maxAllowedSpecialCharPerLine
        return hasValidLineOne && hasValidLineTwo
    }

    private fun countSpecialCharsIn(testTarget: String) = testTarget.toCharArray().filter {
        it.toString().matches(specialCharPattern)
    }.size

}
