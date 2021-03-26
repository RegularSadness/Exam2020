package exam

import java.io.File
import java.lang.IllegalArgumentException
import java.lang.StringBuilder

fun example(inputName: String): Int {
    if ("ultimate question" in File(inputName).readText().toLowerCase()) {
        return 42
    }
    throw IllegalStateException()
}

// Пожалуйста добавьте необходимые параметры,
// тип результата, и измените имя функции (Shift+F6)
fun pressure(inputName: String, query: String): String {
    var reader = File(inputName).bufferedReader()
    var dateWithPressure = mutableListOf<String>()
    var result = ""
    var finalResult = ""

    reader.forEachLine {
        dateWithPressure = it.split(": ", ", ") as MutableList<String>
    }

    if (!query.split(" ").contains(">") && !query.split(" ").contains("<")) {
        throw IllegalArgumentException("Invalid Argument.")
    }

    if (query.split(" ").contains("<")) {
        for (i in 0 until dateWithPressure.size step 2) {
            if (i < dateWithPressure.size - 2) {
                if (dateWithPressure[i + 1].toInt() < dateWithPressure[i + 3].toInt()) {
                    result = result + dateWithPressure[i] + ": " + dateWithPressure[i + 1] + ", "
                }
            }
        }
    }

    if (query.split(" ").contains(">")) {
        for (i in 0 until dateWithPressure.size step 2) {
            if (i < dateWithPressure.size - 2) {
                if (dateWithPressure[i + 1].toInt() > dateWithPressure[i + 3].toInt()) {
                    result = result + dateWithPressure[i] + ": " + dateWithPressure[i + 1] + ", "
                }
            }
        }
    }

    result.toCharArray()
    for (i in 0..result.length - 3) {
        finalResult += result[i]
    }

    finalResult += "."
    //println(finalResult)
    return finalResult
}