package com.example.studykotlin.delegate

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午9:19
 */
class Delegation(val base: Base) : Base {

    override fun log(message: String) {
        base.log(message)
    }

    override fun isEnabled(): Boolean {
        return base.isEnabled()
    }

}

// 方法委托
class Delegation2(private val base: Base) : Base by base {
    override fun log(message: String) {
        base.log("override log $message")
    }
}