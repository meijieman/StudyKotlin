package com.example.studykotlin.delegate

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午9:20
 */

fun main() {
//    val delegation = Delegation(BaseImpl())
//    delegation.log("test")

    val delegation2 = Delegation2(BaseImpl())
    delegation2.log("test")
}