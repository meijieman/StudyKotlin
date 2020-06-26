package com.example.studykotlin.first

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.FileInputStream

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test1() {
        val str: String? = ""

        println("is notNull 2 ${str.isNotNull()}")
    }

    fun String?.isNotNull(): Boolean = this != null


    companion object {
        const val TT = "abc"

    }

    @Test
    fun test2() {
        printAllUppercase(listOf("foo", "Bar"))
        printAllUppercase(listOf("FOO", "BAR"))
    }

    fun printAllUppercase(data: List<String>) {
        val result = data
            .filter { it.all { c -> c.isUpperCase() } }
            .ifEmpty { listOf("<no uppercase>") }
        result.forEach { println("111 $it") }
    }

    @Test
    fun test3() {

        val a = parseInt("222")

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter { it.startsWith("a") }
            .sortedBy { it.get(1) }
            .map {
                it.toUpperCase()
            }
            .forEach { println(it) }
    }

    fun parseInt(str: String): Int? = str.toIntOrNull()


    @Test
    fun test4() {
        val v = null

        v?.let {
            println("let is $v")
        }

        println("end")

    }

    @Test
    fun test5() {
        val numbers = listOf("one", "two", "three", "four")
        numbers
            .first()
            .let { firstItem ->
                println("The first item of the list is '$firstItem'")
                if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
            }
            .toUpperCase()
            .let {
                println("222 First item after modifications: '$it'")
            }
    }

    @Test
    fun test6() {
        listOf(2, 3, 4, 5)
        val block: (Map<String, Int>) -> Unit = {
            println("it -> $it")

            for ((k, v) in it) {
                println("key $k, value $v")
            }
        }
        mapOf("a" to 1, "b" to 2, "c" to 3).let(block)

        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        block(map)

    }

    @Test
    fun test7() {

        val block2: () -> String = {
            println("eee")
            "end"
        }

        block2()
    }

    @Test
    fun test8() {
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)

        for (key in map.keys) {
            println("key $key -> value ${map[key]}")
        }

        println("------------")

        // run函数实际上可以说是let和with两个函数的结合体，run函数只接收一个lambda函数为参数，以闭包形式返回，返回值为最后一行的值或者指定的return的表达式。
        map.run {
            println("this is $this")
            println("size $size") // 省略 this
            for (key in this) {
                println("this k is $key")
            }
        }

        println("------------")

        "xiaoming".run {
            println("len ${this.length}")
            println("code ${this.hashCode()}")
            println("int ${this.toIntOrNull()}")
        }
    }

    @Test
    fun test9() {
        s = "major"
        println("s $s")

        println("name $name")

        calc()
    }

    // lateinit var只能用来修饰类属性，不能用来修饰局部变量
    lateinit var s: String


    // by lazy本身是一种属性委托。属性委托的关键字是by。
    val name: Int by lazy { 2 }

    fun calc() {
        println("声明之前")
        val bb: String by lazy {
            println("sleep 3")
            Thread.sleep(1000 * 3)
            "sss"
        }
        println("声明之后")
        println("bb $bb")
        println("调用之后")
    }

    @Test
    fun test10() {
        val str = Resource.name

    }

    // 单例
    object Resource {
        val name = "Name"
    }

    @Test
    fun test11() {
        // 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可
        val w = with("abc") {
            println("with $this")
            println("len $length")
            println("code ${hashCode()}")

            false
        }
        println("w $w")
    }

    @Test
    fun test12() {
        // 从结构上来看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样，run函数是以闭包形式返回最后一行代码的值，而apply函数的返回的是传入对象的本身。
        val rst = "SSS".apply {
            println("apply $this ")
            println("len $length")
        }
        println("rst $rst")
    }

    @Test
    fun test13() {
        // also函数的结构实际上和let很像唯一的区别就是返回值的不一样，let是以闭包的形式返回，返回函数体内最后一行的值，如果最后一行为空就返回一个Unit类型的默认值。而also函数返回的则是传入对象的本身

        val s = "abc".also {
            println("ada $this")
            "bbb"
        }

        println("s $s")

        // 交换连个变量
        var a = 2
        var b = 3
        println("a $a, b $b")

        a = b.also { b = a }

        println("交换后 a $a, b $b")
    }

    @Test
    fun test14() {
        val stream = FileInputStream("d:/ggg.txt")
        stream.buffered().reader().use { reader ->
            println(reader.readText())
        }
    }

    fun method(): Unit = TODO()

    var todo: String = TODO()
}
