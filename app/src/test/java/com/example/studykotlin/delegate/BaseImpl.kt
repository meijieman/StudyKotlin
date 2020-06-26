package com.example.studykotlin.delegate

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午9:18
 */
class BaseImpl : Base {

    override fun log(message: String) {
        println(message)
    }

    override fun isEnabled(): Boolean {
        return true
    }
}