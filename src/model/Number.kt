package model

abstract class Number {
    protected abstract val value: Any
    abstract fun extractValue(): Pair<Double, Double>
}