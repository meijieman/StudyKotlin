package com.example.studykotlin.highOrderFunction

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午11:51
 */

// 高阶函数
var inc: (Int) -> Int = fun(x: Int): Int {
    return x + 1
}

fun main() {

    println(inc(2))

    // :: 为反射 api 中的操作符
    val incRef: (Int) -> Int = inc

    println(incRef(8))

}

fun test() {

    val incRef = ::inc
    println(incRef())
    println(incRef)
}