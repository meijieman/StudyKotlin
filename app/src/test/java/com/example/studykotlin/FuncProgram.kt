package com.example.studykotlin

import org.junit.Test

/**
 * 函数式编程
 *
 * @author meijie05
 * @since 2020/6/24 上午6:38
 */

class FuncProgram {

    @Test
    fun test() {
        // map()
        val numbers = intArrayOf(1, 2, 3, 4, 5, 6) // 数组
        val numbersResult = numbers.map { it * 10 }
        println(numbersResult)

        val score = listOf(20, 30, 70) // 集合
        val scoreRet = score.map { if (it > 60) "及格" else "需要努力" }
        println(scoreRet)

    }

    @Test
    fun test0() {
        val numbers = intArrayOf(1, 2, 3)
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)

        println("${numbers::class.java}")
        print(numbers1::class.java)
    }


    @Test
    fun test1() {
        // flatMap()
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)
        val numbers2 = listOf(10, 20, 30)

        val numbers = listOf(numbers1, numbers2)

        val flatMapResult: List<Int> = numbers.flatMap {
            it.map { it * 10 }
//            it.asIterable()
        }
        println(flatMapResult)

        println(numbers.flatten())
    }

    @Test
    fun test2() {
        // zip()
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)
        val numbers2 = listOf(10, 20, 30)
        val zipResult1: List<Pair<Int, Int>> = numbers1.zip(numbers2)
        println(zipResult1)

        val zipResult2 = numbers2.zip(numbers1)
        println(zipResult2)

    }

    @Test
    fun test3() {
        // reduce()
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)
        val reduce = numbers1.reduce { acc, i -> acc - i }
        println(reduce)

        val reduce1 = numbers1.reduce { acc, i -> acc + i }
        println(reduce1)
    }

    @Test
    fun test4() {
        // fold() ，与 reduce() 类似，但是可以指定初始累计值
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)
        // 初始累计值为 2
        numbers1.fold(2) { acc, n ->
            acc - n
        }.also {
            println(it)
        }

        numbers1.foldRight(0) { acc, n ->
            acc + n
        }.apply { println(this) }


        // also apply let with run
    }

    @Test
    fun test5() {
        // filter()
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)
        numbers1.filter { it % 2 == 0 }
            .apply { println(this) }
    }

    @Test
    fun test6() {
        // forEach()
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)
        numbers1.forEach { print("$it -> ") }
    }

    @Test
    fun test7() {
        // partition() 分区操作
        val numbers1 = listOf(1, 2, 3, 4, 5, 6)
        numbers1.partition { it % 2 == 0 }
            .apply { println(this) }

        numbers1.partition { it % 3 == 0 }
            .apply { println("first $first, second $second") }

    }

}
