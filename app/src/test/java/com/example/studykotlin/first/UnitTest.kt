package com.example.studykotlin.first

import org.junit.Test
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.concurrent.thread

/**
 * @desc: TODO
 * @author: Major
 * @since: 2020/4/16 23:07
 */
class UnitTest {

    @Test
    fun test1() {

        val path = "../file.txt"
        val file = File(path)
        println("file path ${file.absolutePath}")
//        if (!file.exists()) {
//            val result = file.createNewFile()
//            println("create file $result")
//        }

        val writer = FileOutputStream(file, true).bufferedWriter()

        writer.use {
            it.run {
                write("how can i do.")
                newLine()
                write("no answer")
                newLine()
            }
        }

        println("write over")

        // Closeable#use 函数，执行该函数接收到的函数，然后关闭流
        FileInputStream(path)
            .buffered()
            .reader()
            .use {
                println("输出为 ${it.readText()}")
            }
    }

    @Test
    fun test2() {
        println("current thread0 is ${Thread.currentThread().name}")
        thread {
            println("current thread is ${Thread.currentThread().name}")
        }
        thread {
            println("current thread2 is ${Thread.currentThread().name}")
        }
    }


    @Test
    fun test3() {
        val count = countPlus()
        count()
        count()
        count()

    }

    // 闭包
    fun countPlus(): () -> Unit {
        var count = 0
        return {
            count++
            println("count $count")
        }
    }

    val test = if (5 < 3) {
        println("yes")
    } else {
        println("no")
    }


    @Test
    fun test4() {
        val a: Float = 33000f / 7
        val c: Float = 140000f / 8

        println("a $a, c $c ${c / a}")
    }
}