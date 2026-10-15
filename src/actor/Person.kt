package actor

import calc.Expression
import model.AbstractComplex

class Person(val name: String) {

    fun evaluateExpression(
        real: Double,
        imag: Double,
        mod: Double,
        phase: Double,
        operation: String
    ): AbstractComplex {

        val expr = Expression(operation, real, imag, mod, phase)
        return expr.calculateResult()
    }
}


fun inputDouble(prompt: String): Double {
    while (true) {
        println(prompt)
        print("Введите число: ")
        val value = readln().toDoubleOrNull()
        if (value != null) return value
        println("Ошибка")
    }
}

fun inputOperation(): String {
    val validOps = setOf("+", "-", "*", "/")
    while (true) {
        print("Введите операцию (+, -, *, /): ")
        val op = readln().trim()
        if (op in validOps) return op
        println("ошибка")
    }
}

fun main() {
    val person = Person("Ваня")
    println("Здравствуйте, ${person.name}.")

    println("Введите первое число (алгебраический вид):")
    val real = inputDouble("Действительная часть")
    val imag = inputDouble("Мнимая часть")

    println("Введите второе число (показательный вид):")
    var mod: Double
    while (true) {
        mod = inputDouble("Модуль")
        if (mod >= 0.0) break
        println("ошибка")
    }
    val phase = inputDouble("Фаза")

    val op = inputOperation()
        val result = person.evaluateExpression(real, imag, mod, phase, op)
        println("Результат: $result")

}