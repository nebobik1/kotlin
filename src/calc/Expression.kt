package calc

import model.AbstractComplex
import model.ComplexAlgebraic
import model.ComplexExponential
import model.Number

class Expression(
    val operation: String = "+",
    firstReal: Double,
    firstImag: Double,
    secondMod: Double,
    secondPhase: Double
) {

    val numbers: MutableList<Number> = mutableListOf(
        ComplexAlgebraic(firstReal, firstImag),
        ComplexExponential(secondMod, secondPhase)
    )


    fun calculateResult(): AbstractComplex {

        return performOperation()
    }


    private fun performOperation(): AbstractComplex {
        require(numbers.size >= 2) { "недостаточно чисел" }
        val first = numbers[0] as? ComplexAlgebraic
            ?: throw IllegalStateException("число1 должно быть ComplexAlgebraic")
        val second = numbers[1] as? AbstractComplex
            ?: throw IllegalStateException("число2 должно быть AbstractComplex")

        return first.executeAction(operation, second)
    }
}