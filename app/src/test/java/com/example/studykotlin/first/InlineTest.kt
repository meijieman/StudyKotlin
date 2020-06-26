package com.example.studykotlin.first

import org.junit.Test

/**
 * @desc: TODO
 * @author: Major
 * @since: 2020/4/18 7:52
 */

class InlineTest {
    @Test
    fun testLet() {
        val r = "Xiaoming".let {
            // 可以在作用于范围内使用 it 指代函数的调用者
            println(it.length)
            println(it.first().isUpperCase())

            "over" // 返回值
        }
        println("r $r")

        val str: String? = null

        str?.let {
            // 当函数的调用者为非 null 时，会进入 let 函数中
            println("str is not null, $it")
        }

    }

    @Test
    fun testWith() {
        val with = with("Abc") {
            println(length)
            first().isUpperCase() // 返回值
        }

        println("with $with")
    }

    @Test
    fun testRun() {
        val run = "Abc".run {
            println("len $length")
            last().isLowerCase() // 返回值
        }
        println("run $run")

    }

    @Test
    fun testApply() {
        val run = "Abc".apply {
            println("len $length")
            last().isLowerCase() // 返回值
        }
        println("run $run")


        val data = Data()
//        data.sub = Sub()
//        data.sub!!.s = "major"
        val value = getValue(data)
        println("value is $value")

    }

    fun getValue(data: Data?): String? = data?.apply {}?.sub.apply { }?.s ?: "noValue"

    @Test
    fun testAlso() {
        val r = "Xiaoming".also {
            // 可以在作用于范围内使用 it 指代函数的调用者
            println(it.length)
            println(it.first().isUpperCase())

            "over"
        }
        println("r $r")

    }

    class Data {
        var sub: Sub? = null
    }

    class Sub {
        var s: String? = null
    }
}