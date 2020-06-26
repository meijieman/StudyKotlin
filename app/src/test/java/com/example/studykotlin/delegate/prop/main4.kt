package com.example.studykotlin.delegate.prop

import kotlin.properties.Delegates

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午10:47
 */

class B {
    // 非空属性委托
    var notNullStr: String by Delegates.notNull<String>()

    // lateinit 与非空属性委托一样？
    lateinit var notNullStr2: String
}


fun main() {
    val b = B()
    b.notNullStr = "bar"

    println("notNullStr ${b.notNullStr}")
}