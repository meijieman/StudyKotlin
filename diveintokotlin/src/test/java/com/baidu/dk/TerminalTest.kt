package com.baidu.dk

import org.junit.Test

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/4/24 12:44 PM
 */
class TerminalTest {

    @Test
    fun test() {
        val fetch = fetch(Terminal1::class.java)
        fetch.func1()

        val t2 = fetch(Terminal2::class.java)
        t2.method1()
    }


    private fun <T : Terminal> fetch(t: Class<T>): T {
        if (t.isAssignableFrom(Terminal1::class.java)) {
            return Entity1() as T::class
        } else {
            return Entity2() as T::class
        }
    }


    interface Terminal {

    }

    class Entity1 : Terminal1 {
        override fun func1() {
            println("func1")
        }
    }

    class Entity2 : Terminal2 {
        override fun method1() {
            println("method1")
        }

    }

    interface Terminal1 : Terminal {
        fun func1()
    }

    interface Terminal2 : Terminal {
        fun method1()
    }
}