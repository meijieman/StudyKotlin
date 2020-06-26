package com.example.studykotlin.delegate

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午8:47
 */
interface Base {
    fun log(message: String)

    fun isEnabled(): Boolean
}