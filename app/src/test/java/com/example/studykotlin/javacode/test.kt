@file:JvmName("GlobalUtil")

package com.example.studykotlin.javacode

import java.io.File
import java.io.FileInputStream
import java.io.IOException

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

// @Throws 提醒 java 代码主动进行异常捕获
@Throws(IOException::class)
fun getInputStream(filename: String): FileInputStream {
    val file = File(filename)
    return FileInputStream(file)
}