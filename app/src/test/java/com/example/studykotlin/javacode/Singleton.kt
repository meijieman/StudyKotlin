package com.example.studykotlin.javacode

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/2 上午7:27
 */
// 单例对象
object Singleton {
    lateinit var name: String

    const val id = 1

    @JvmStatic
    fun fooByAnno(){
        println("...")
    }

    fun foo(){
        println("单例对象方法")
    }
}

const val MAX_INT = Int.MAX_VALUE