package model


abstract class AbstractComplex: Number() {
    abstract fun plus(other: AbstractComplex): AbstractComplex
    abstract fun minus(other: AbstractComplex): AbstractComplex
    abstract fun times(other: AbstractComplex): AbstractComplex
    abstract fun div(other: AbstractComplex): AbstractComplex
}