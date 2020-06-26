package com.example.studykotlin.delegate.prop

import kotlin.properties.Delegates

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午10:35
 */
class User {

    // 使用观察者属性委托
    var name: String by Delegates.observable("<init value>") { property, oldValue, newValue ->
        if (oldValue != newValue) {
            println("$oldValue -> $newValue")
        }
    }

    // 使用 vetoable 属性委托，返回 true 执行对属性的修改， false 则取消对属性的修改
    var age: Int by Delegates.vetoable(0) { property, oldValue, newValue ->

        if (newValue < 20)
            true
        else {
            println("不会赋值")
            false
        }
    }
}

fun main() {
    val user = User()
    println(user.name)

    user.name = "first"
    println(user.name)

    user.name = "first"
    println(user.name)

    user.name = "second"
    println(user.name)

    println("----------")
    user.age = 10
    println(user.age)

    user.age = 20
    println(user.age)
}

