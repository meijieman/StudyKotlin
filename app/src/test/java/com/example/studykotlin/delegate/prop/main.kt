package com.example.studykotlin.delegate.prop

import kotlin.reflect.KProperty

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午9:44
 */

fun main() {
    val logger = Logger()
    logger.logLevel = 3
    println(logger.logLevel)

    // 局部变量委托
    val str: String by DelegationVal()
    println(str)

}


class DelegationVal {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String {
        return "hello world"
    }
}