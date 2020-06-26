package com.example.studykotlin.first

/**
 * @desc: TODO
 * @author: Major
 * @since: 2020/4/18 22:28
 */
val string = "Hello World"

fun makeFun(): () -> Unit {
    var count = 0

    return fun() {
        println(++count)
    }
}

// 菲波拉契序列
fun fibonacci(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {
            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first

                return result
            }

            override fun hasNext() = true
        }
    }
}

fun main() {
    val x = makeFun()
    x()

    for (i in fibonacci()) {
        if (i > 100) break
        println(i)
    }

    println("===============")
    val add5 = add(13)
    println("add5 is $add5")
    // add5 指向的是一个函数，函数为 fun(y:Int) = 13 + y
    println(add5(56)) // 调用add5 函数，返回 13 + 56 = 69
    println(add5(1))

}


fun add(x: Int): (Int) -> Int {
    return fun(y: Int) = x + y
//    return fun(y: Int): Int {
//        return x + y
//    }
}








