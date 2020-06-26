package com.example.studykotlin

import java.io.File
import java.nio.charset.Charset

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/24 上午7:29
 */
class WordCount {
    fun process(resourceName: String) {

        val path = javaClass.classLoader?.getResource("")?.path
        println("path $path")

        val resource = javaClass.getResource(resourceName)

        println("-> ${resource?.path}")

        File(resourceName).inputStream()
            .reader(Charset.forName("UTF-8"))
            .readLines()

        val lines: List<String> = javaClass.getResourceAsStream(resourceName)!!
            .reader(Charset.forName("UTF-8"))
            .readLines()

        val linesWords: List<List<String>> = lines.map { it.split(" ") }
        val words: List<String> = linesWords.flatten()

        val wordsCountPairs: List<Pair<String, Int>> = words.map { Pair(it, 1) }
        val wordsCount = wordsCountPairs.fold(mutableMapOf<String, Int>()) { map, pair ->
            val count = map[pair.first]
            map[pair.first] = (count ?: 0) + pair.second

            map
        }

        wordsCount.forEach { (word, count) ->
            println("$word 出现了 $count")
        }
    }
}

fun main() {
    WordCount().process("/words.txt")
}