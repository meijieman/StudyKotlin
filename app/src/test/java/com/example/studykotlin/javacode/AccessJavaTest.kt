package com.example.studykotlin.javacode

import org.junit.Test

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/2 上午6:28
 */
class AccessJavaTest {

    @Test
    fun test() {
        val bean = JavaBean("test")
        // is 是 kt 的关键字
        val isSame = bean.`is`("major")
    }

    @Test
    fun test1() {
        val bean = JavaBean("test")
        bean.name = "major"
        bean.name = null

        // bean.name 既可以赋值给 kt 的可空类型，也可以赋值给非空类型，是因为 kt 对 java 使用了特殊的平台类型表示
        // kotlin 使用平台类型 T! 表示数据类型可能是 T，也可能是 T?
        var name: String = bean.name
        name = "yun"
//        name = null

        var name2: String? = bean.name
        name2 = null

    }

    @Test
    fun test2() {
        val bean = JavaBean("test")

        bean.a = "B"
    }

    /*
    Object 类在 kt 中的对应类为 Any
    但是 Any 类只声明了 toString(), hashCode() 和 equals() 方法
    如果要使用 java 的 wait()/notify()/notifyAll() 方法，有两种方式
    1. kt 转 java 后使用
    2. 使用 java 同步包的 await(), signal() 和 signalAll() 方法进行替换
     */
    @Test
    fun test3() {
        val bean = JavaBean("test")
        (bean as java.lang.Object).wait()
    }

    @Test
    fun test4() {
        val bean = JavaBean("test")

        // 扩展属性
        val javaClass = bean.javaClass
        val javaClass2 = JavaBean::javaClass

        // 反射 api
        val javaClass1 = bean::class.java

        println("$javaClass, $javaClass1")

    }

    @Test
    fun test5() {
        val bean2 = JavaBean2()
        // JavaBean2 生成 kt 代码时，对于参数是 lambda 类型的，生成了两个对应的 kt 方法
        bean2.setOnClickListener(object : OnClickListener {
            override fun onClick() {
                println("click")
            }
        })

        bean2.setOnClickListener {
            println("lambda click")
        }
    }


    // kt 中定义 native 方法，使用 external 方法
    external fun sum(x: Int, y: Int): Int


    @Test
    fun test6() {
        val `is` = getInputStream("")
    }
}