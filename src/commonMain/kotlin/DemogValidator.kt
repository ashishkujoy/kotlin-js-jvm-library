package org.learning

import domain.Address

object DemogValidator {
    private val specialCharPattern = Regex("[@#^&():;|<>\\-./,{}=_~\\[\\] ]+")
    private const val maxAllowedSpecialCharPerLine = 5

    fun isValidAddress(address: Address): Boolean {
        val hasValidLineOne = countSpecialCharsIn(address.lineOne) <= maxAllowedSpecialCharPerLine
        val hasValidLineTwo = countSpecialCharsIn(address.lineTwo) <= maxAllowedSpecialCharPerLine
        return hasValidLineOne && hasValidLineTwo
    }

    private fun countSpecialCharsIn(testTarget: String) = testTarget.toCharArray().filter {
        it.toString().matches(specialCharPattern)
    }.size
}

