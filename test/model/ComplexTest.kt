package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ComplexTest {

    @Test
    fun plus() {
        val a = ComplexAlgebraic(1.0, 2.0)
        val b = ComplexAlgebraic(3.0, 4.0)
        val res = a.plus(b)
       assertEquals("4.0 + 6.0i", res.toString())

    }

    @Test
    fun minus() {
        val a = ComplexAlgebraic(5.0, 7.0)
        val b = ComplexAlgebraic(2.0, 3.0)
        val res = a.minus(b)
        assertEquals("3.0 + 4.0i", res.toString())

    }

    @Test
    fun times() {
        val a = ComplexAlgebraic(1.0, 2.0)
        val b = ComplexAlgebraic(3.0, 4.0)
        val res = a.times(b)
        assertEquals("-5.0 + 10.0i", res.toString())
    }

    @Test
    fun div() {
        val a = ComplexAlgebraic(6.0, 8.0)
        val b = ComplexAlgebraic(2.0, 0.0)
        val res = a.div(b)
        assertEquals("3.0 + 4.0i", res.toString())

    }

    @Test
    fun divByZero() {
        val a = ComplexAlgebraic(1.0, 2.0)
        val b = ComplexAlgebraic(0.0, 0.0)
        assertThrows(IllegalArgumentException::class.java) {
            a.div(b)
        }
    }

    @Test
    fun negativeModulus() {
        assertThrows(IllegalArgumentException::class.java) {
            ComplexExponential(-1.0, 0.0)
        }
    }


}