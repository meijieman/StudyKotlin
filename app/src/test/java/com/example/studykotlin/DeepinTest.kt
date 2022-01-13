package com.example.studykotlin;

import org.junit.Test;
import kotlin.concurrent.thread

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/12/17 7:41 下午
 */

class DeepinTest {

    val callback = {
        println("D")
    }

    val task = {
        println("C")
        callback()
    }


    @Test
    fun test() {
        println("A")
        thread(block = task)
        println("B")
    }

}
