package com.example.studykotlin.io

import org.junit.Test
import java.io.File
import java.io.FileWriter
import java.util.*

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/26 上午8:03
 */
class IoTest {

    @Test
    fun test() {
        val filepath = "../words.txt"
        val file = File(filepath)
        println(file.absolutePath)
        if (!file.exists()) {
            println("create file")
            file.createNewFile()
        } else {
            println("file exists")
        }

//        file.writeText()
//        file.outputStream().bufferedWriter().use {
//            it.write("xxx")
//        }

        // 追加
        FileWriter(file, true).buffered().use {
            it.write("aha ${Date().toLocaleString()}")
            it.newLine()
        }

//        val readText = file.readText()
        // use 可以自动关闭流操作
        val readLines = file.inputStream().use {
            it.bufferedReader().readLines()
        }
        readLines.forEach {
            println(it)
        }

    }

    @Test
    fun test1() {
        val dir = "."
        // walk 读取目录
        val walk = File(dir).walk().maxDepth(1)
        walk.forEach(::println)
    }
}