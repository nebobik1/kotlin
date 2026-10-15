package model
import kotlin.math.*

class ComplexExponential(
    private var modulus: Double,
    private var phase: Double
) : AbstractComplex() {

    init {
        if (modulus < 0.0) throw IllegalArgumentException("модуль не может быть отрицательным")
    }

    override val value: Pair<Double, Double>
        get() = Pair(modulus, phase)


    private fun toAlgebraic(): ComplexAlgebraic {
        val real = modulus * cos(phase)
        val imaginary = modulus * sin(phase)
        return ComplexAlgebraic(real, imaginary)
    }


    override fun extractValue(): Pair<Double, Double> {
        val algebraic = toAlgebraic()
        return algebraic.extractValue()
    }

    override fun plus(other: AbstractComplex): AbstractComplex = toAlgebraic().plus(other)
    override fun minus(other: AbstractComplex): AbstractComplex = toAlgebraic().minus(other)
    override fun times(other: AbstractComplex): AbstractComplex = toAlgebraic().times(other)
    override fun div(other: AbstractComplex): AbstractComplex = toAlgebraic().div(other)

    override fun toString(): String = "$modulus * e^(${phase}i)"
}