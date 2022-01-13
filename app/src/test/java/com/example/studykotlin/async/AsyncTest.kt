package com.example.studykotlin.async

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.Runnable
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/26 上午9:36
 */

var outterVar:Int = 2
class AsyncTest {

    var innerVar:Int = 3

    @Test
    fun test0() {
        println("out start ${Thread.currentThread().name}")
        GlobalScope.launch {
            println("start ${Thread.currentThread().name}")
            withContext(Dispatchers.IO) {
                println("耗时操作 ${Thread.currentThread().name}")
                delay(1000)
            }
            println("end ${Thread.currentThread().name}")
        }

        Thread.sleep(3000)

        println("${outterVar * 2}")
        println("${innerVar * 2}")
    }



    @Test
    fun test() {
        // 使用 java 的 Thread 类
        val thread = Thread() {
            run {
                println("线程运行中...")
            }
        }

        thread.start()
    }

    @Test
    fun test1() {
        // 使用 java 的 Runnable
        val runnable = Runnable {
            println("线程运行中")
        }

        Thread(runnable).start()


        val runnable1 = Runnable {
            run {
                println("xxxxxx")
            }
        }
        Thread(runnable1).start()
    }

    @Test
    fun test2() {
        thread(start = true, name = "自定义线程") {
            println("使用 kotlin 的 thread。 ${Thread.currentThread().name}")
        }
    }

    @Test
    fun test3() {
        val thread = thread(false) {
            println("kkk")
        }

        thread.start()
    }

    // 使用协程     implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'
    @Test
    fun test4() {
        GlobalScope.launch {
            delay(1000)
            println("world")
        }
        println("hello")
    }

    @Test
    fun test5() {
        // 阻塞当前线程
        runBlocking {
            delay(1000)
            println("world")
        }
        println("hello")
    }

    @Test
    fun test6() = runBlocking {
        delay(1000)
        println("end")
    }

    @Test
    fun test7() = runBlocking {
        val job1 = launch {
            delay(1000)
            println("协程1执行中")
        }
        job1.join()
        println("协程1执行完成")

        val job2 = launch {
            delay(1000)
            println("协程2执行中")
        }
        job2.cancel()

        delay(1200)
        println("主协程执行完成")
    }

    // 协程状态 isActive isCompleted isCancelled
    @Test
    fun test8() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextTime = startTime
            var i = 0
            while (isActive && i < 15) {
                if (System.currentTimeMillis() >= nextTime) {
                    println("休眠 ${i++} 次")
                    nextTime += 500L
                }
            }
        }
        delay(1000)

        println("取消协程")
        job.cancel()
        println("执行完毕")

    }

    @Test
    fun test9() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextTime = startTime
            var i = 0
            while (i < 15) {
                // yield 挂起函数，可以被取消
                yield()
                if (System.currentTimeMillis() >= nextTime) {
                    println("休眠 ${i++} 次")
                    nextTime += 500L
                }
            }
        }
        delay(10)
        println("取消协程")
        job.cancel()
        println("执行完毕")

    }

    @Test
    fun test10() = runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("休眠 $i++ 次")
                    delay(500)
                }
            } finally {
                // withContext 切换上下文， NonCancellable 不可被取消
                withContext(NonCancellable) {
                    println("finally start")
                    delay(1000) // 会抛出 CancellationException
                    println("finally end")
                }
            }
        }
        delay(1200)
        println("等待取消协程")
        job.cancelAndJoin()
        println("主协程退出执行")

    }

    @Test
    fun test11() = runBlocking {
        try {
            // 超时取消
            withTimeout(1300) {
                repeat(1000) { i ->
                    println("休眠 $i")
                    delay(500)
                }
            }
        } catch (e: TimeoutCancellationException) {
            println("timeout")
        }

    }

    @Test
    fun test12() = runBlocking {
        // withTimeoutOrNull 超时返回 null，没有超时返回 Unit
        val timeout = withTimeoutOrNull(1300) {
            repeat(1000) {
                println("休眠 $it")
                delay(500)
            }
        }

        println(timeout)

    }

    // 挂起函数
    suspend fun getNumber1(): Int {
        delay(1000)
        return 1
    }

    suspend fun getNumber2(): Int {
        delay(2000)
        return 2
    }

    @Test
    fun test13() = runBlocking {
        val duration = measureTimeMillis {
            getNumber1()
            getNumber2()
        }
        println(duration)
    }

    @Test
    fun test14() = runBlocking {
        // async 方法
        val duration = measureTimeMillis {
            val action1: Deferred<Int> = async { getNumber1() }
            val action2: Deferred<Int> = async { getNumber2() }
            println(action1.await() + action2.await())

//            val resultList: List<Int> = awaitAll(action1, action2)
//            println(awaitAll(action1, action2).sum())
        }
        println(duration)

    }

    @Test
    fun test15() = runBlocking {
        // 不指定上下文
        val job1 = launch {
            println("运行在主协程中，线程名 ${Thread.currentThread().name}")
        }

        // 使用非受限调度器
        val job2 = launch(Dispatchers.Unconfined) {
            println("Unconfined，线程名 ${Thread.currentThread().name}")
        }

        val job3 = launch(Dispatchers.Default) {
            println("Default，线程名 ${Thread.currentThread().name}")
        }

        // 自定义线程池
        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        // 将线程池转为调度器
        val dispatcher: CoroutineDispatcher = executor.asCoroutineDispatcher()
        val job4 = launch(dispatcher) {
            println("newSingleThreadExecutor，线程名 ${Thread.currentThread().name}")
        }

        joinAll(job1, job2, job3, job4)

        executor.shutdown()
    }

    @Test
    fun test16() = runBlocking {
        val job1 = launch {
            println("主协程调度器: ${Thread.currentThread().name}")
            delay(1000)
            println("主协程调度器中恢复: ${Thread.currentThread().name}")
        }

        val job2 = launch(Dispatchers.Unconfined) {
            println("Unconfined 调度器: ${Thread.currentThread().name}")
            delay(500)
            println("Unconfined 调度器中恢复: ${Thread.currentThread().name}")

        }

        joinAll(job1, job2)
        println("over")
    }

    @Test
    fun test17() = runBlocking {
        // 协程作用域

        val job = launch {
            // 全局协程
            GlobalScope.launch {
                println("GlobalScope start")
                delay(1000)
                println("GlobalScope end")
            }

            // 子协程
            launch {
                println("CoroutineScope start")
                delay(1000)
                println("CoroutineScope end")
            }
        }

        delay(500)
        job.cancel()
        delay(1000)
        println("主协程退出")
    }

    @Test
    fun test18() = runBlocking {
        // 协程中抛异常
        val job = launch {
            launch {
                println("CoroutineScope start")
                delay(700)
                throw RuntimeException()
                println("CoroutineScope end")
            }
            launch {
                println("CoroutineScope2 start")
                delay(1000)
                println("CoroutineScope2 end")
            }
        }
        job.join()
        println("主协程退出")

    }

    @Test
    fun test19() = runBlocking {
        // 组合上下文
        async(CoroutineName("io_alias") + Dispatchers.IO) {
            println(Thread.currentThread().name)
        }

        delay(1000)

        println() // 这一行不能省略，否则返回的不是 Unit
    }


    val data = MutableList(10) {
        if (it < 5) {
            Random().nextInt(10)
        } else {
            0
        }
    }

    @Test
    fun test20() {

        println(data)
    }
}