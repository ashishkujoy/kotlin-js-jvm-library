package org.learning

import kotlin.js.JsName

class Mathematics {
    @JsName("add")
    fun add(a: Int, b: Int): Int = a + b
    @JsName("subtract")
    fun subtract(a: Int, b: Int): Int = a - b
    @JsName("multiply")
    fun multiply(a: Int, b: Int): Int = a * b
    fun divide(a: Int, b: Int): Int = a / b
}