package com.example.studykotlin

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 下午3:44
 */

// 内联函数默认函数参数也会被内联，如果不喜欢参数被内联，使用 noinline
inline fun reduce(list: List<Int>, noinline f: (Int, Int) -> Int): Int {
    var result = 0
    for (i in list) {
        result = f(i, result)
    }
    return result
}


fun main() {

    val reduce = reduce(listOf(1, 6, 9)) { a, b ->
        a + b
    }

    println(reduce)
}