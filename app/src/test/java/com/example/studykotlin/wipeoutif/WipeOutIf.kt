package com.example.studykotlin.wipeoutif

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/8/16 上午9:56
 */
fun main() {

    map2["bbb"] = fun() {
        println("invoke bbb")
    }

    good2("bbb")
}

fun bad(input: String) {
    if ("aaa" == input) {

    } else if ("bbb" == input) {

    } else if ("ccc" == input) {

    } else {

    }
}

fun good2(input: String) {
    if (map2.containsKey(input)) {
        // 调用匿名函数
        map2[input]?.invoke()
//        map2[input]!!()

    } else {
        println("error")
    }
}

var map = mapOf<String, () -> Unit>(
    "aaa" to fun() {

    },
    "bbb" to fun() {

    }
)

var map2 = mutableMapOf<String, () -> Unit>(
    "fff" to fun() {

    },
    "eee" to fun() {

    }
)