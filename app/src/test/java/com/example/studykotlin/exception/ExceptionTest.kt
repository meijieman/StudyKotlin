package com.example.studykotlin.exception

import org.junit.Test

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 下午7:54
 */
class ExceptionTest {

    fun func(): Int {
        var i = 0

        try {
            i++
            return i
        } finally {

            if (i == 1) {
                return 10
            }
        }
    }

    @Test
    fun test() {

        println(func())
    }

    fun parseNumber(s: String): Int {
        if (s == "") {
            return 0
        }

        return try {
            Integer.parseInt(s)
        } catch (e: NumberFormatException) {
            0
        }
    }

    @Test
    fun test1() {
        val parseNumber = parseNumber("520")
        val parseNumber2 = "1314".parseNumber2()

        println("$parseNumber $parseNumber2")
    }

    @Throws(java.lang.RuntimeException::class)
    fun func2(n: Int): Int {
        return if (n % 2 == 0) {
            n / 2
        } else {
            throw  RuntimeException("n must be even")
        }
    }

    @Test
    fun test2() {

        try {
            val i = func2(9)
            println(i)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}


fun String?.parseNumber2(): Int {
    if (this == null || isEmpty()) {
        return 0
    }
    return try {
        Integer.parseInt(this)
    } catch (e: java.lang.NumberFormatException) {
        0
    }
}