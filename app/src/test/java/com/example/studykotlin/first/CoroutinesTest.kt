package com.example.studykotlin.first

import kotlinx.coroutines.*
import org.junit.Test

/**
 * @desc: TODO
 * @author: Major
 * @since: 2020/4/20 22:57
 */

class CoroutinesTest {

    @Test
    fun test1() {
        val job: Job = GlobalScope.launch(Dispatchers.Unconfined) {

            println("enter ")

            delay(1000)
            doWork()
            println("test1 +${Thread.currentThread().name}")
            withContext(Dispatchers.IO) {
                delay(2000)
                println("withContext  + ${Thread.currentThread().name}")

            }

        }

        val runBlocking: String = runBlocking {
            doWork()
            delay(300)

            "xxx"

        }
        Thread.sleep(3000)

    }


    suspend fun doWork() {
        println("hard work")
    }
}