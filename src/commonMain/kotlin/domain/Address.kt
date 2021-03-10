@file:JsExport

package org.learning.domain

import kotlin.js.JsExport

data class Address(val lineOne: String, val lineTwo: String, val zipCode: Int? = null)
