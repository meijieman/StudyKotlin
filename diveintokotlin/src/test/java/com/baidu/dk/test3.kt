package com.baidu.dk

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/4/24 6:47 PM
 */
fun main() {
//    func1()
//    func2()
    func3()

}


fun func1() {
    val listOf = listOf(1, 2, 3, 4, 5)
    val map = listOf.filter { it > 3 }.map { it * 2 }
    println(map)
}

fun func2() {
    // 惰性求值
    // 中间操作，末端操作
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    val map = list.asSequence().filter {
        println("it -> $it")
        it > 3
    }.map {
        println("map -> $it ")
        it * 2
    }

    println("=> $map")
    val toList = map.toList()
    println(toList)
}

fun func3() {
    val naturalNumList = generateSequence(1) { it + 1 }
    val toList = naturalNumList.takeWhile {
        Thread.sleep(300)
        it <= 29
    }.map { print("$it \t") }.toList()
//    println(toList)
}