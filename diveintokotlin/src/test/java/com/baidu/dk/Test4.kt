package com.baidu.dk

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/7/17 12:56 下午
 */
class Test4 {

    @Test
    fun test1() = runBlocking {
        println("start")
        val job = launch {
            repeat(1000) {
                println("job: i'm sleeping $it")
                delay(500)
            }
        }

        delay(1300L)
        println("end")

        job.cancel()
        job.join()
        println("now i can quit.")

    }
}
