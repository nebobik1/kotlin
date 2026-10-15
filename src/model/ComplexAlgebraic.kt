package model
import kotlin.math.*

class ComplexAlgebraic(
    private var real: Double,
    private var imaginary: Double
) : AbstractComplex() {

    override val value: String
        get() = if (imaginary >= 0) "$real + ${imaginary}i" else "$real - ${abs(imaginary)}i"

    override fun extractValue(): Pair<Double, Double> = Pair(real, imaginary)

    private fun toExponential(): ComplexExponential {
        val r = sqrt(real * real + imaginary * imaginary)
        val phi = atan2(imaginary, real)
        return ComplexExponential(r, phi)
    }

    private fun applyOperation(
        other: AbstractComplex,
        op: (r1: Double, i1: Double, r2: Double, i2: Double) -> Pair<Double, Double>
    ): ComplexAlgebraic {

        val (r2, i2) = other.extractValue()
        val (resReal, resImag) = op(real, imaginary, r2, i2)

        return ComplexAlgebraic(resReal, resImag)
    }


    fun executeAction(operation: String, other: AbstractComplex): ComplexAlgebraic {
        return when (operation) {
            "+" -> plus(other)
            "-" -> minus(other)
            "*" -> times(other)
            "/" -> div(other)
            else -> throw IllegalArgumentException("неверная операция: $operation")
        }
    }

    override fun plus(other: AbstractComplex): ComplexAlgebraic =
        applyOperation(other) { r1, i1, r2, i2 ->
            Pair(r1 + r2, i1 + i2)
        }

    override fun minus(other: AbstractComplex): ComplexAlgebraic =
        applyOperation(other) { r1, i1, r2, i2 ->
            Pair(r1 - r2, i1 - i2)
        }

    override fun times(other: AbstractComplex): ComplexAlgebraic =
        applyOperation(other) { r1, i1, r2, i2 ->
            Pair(r1 * r2 - i1 * i2, r1 * i2 + i1 * r2)
        }

    override fun div(other: AbstractComplex): ComplexAlgebraic =
        applyOperation(other) { r1, i1, r2, i2 ->
            val denom = r2 * r2 + i2 * i2
            if (denom == 0.0) throw IllegalArgumentException("деление на ноль")
            Pair((r1 * r2 + i1 * i2) / denom, (i1 * r2 - r1 * i2) / denom)
        }

    override fun toString(): String = value
}