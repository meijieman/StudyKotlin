package com.example.studykotlin.delegate.prop

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午10:50
 */

// 映射属性委托， 将类中的属性值全部保存在 map 中
class Person(map: Map<String, Any?>) {
    val name: String by map

    val age: Int by map
}

fun main() {
    val person = Person(mapOf("name" to "major", "age" to 28))

    // 相当于 person.map["name"]
    println(person.name)

    println(person.age)
}