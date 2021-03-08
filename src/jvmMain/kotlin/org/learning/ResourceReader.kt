package org.learning

import java.io.File

actual fun readResource(filename: String): String = File(filename).readText()