@file:JvmName("GlobalUtil")

package com.example.studykotlin.javacode

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/2 上午7:43
 */

var debug = false

fun test() {
    println("test")
}

@JvmName("test100")
fun test1() {
    println("test1")
}

//fun List<String>.accumlate():String{
//    return joinToString(",")
//}

@JvmName("accumlateInt")
fun List<String>.accumlate(): Int {
    return 2
}
