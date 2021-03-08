package org.learning

import org.w3c.files.FileReader

external fun require(module: String): dynamic

val fs = require("fs")
val process = require("process")
actual fun readResource(filename: String): String {
    fs.writeFileSync("helloworld", process.cwd())
    return fs.readFileSync(filename, "utf-8") as String
}