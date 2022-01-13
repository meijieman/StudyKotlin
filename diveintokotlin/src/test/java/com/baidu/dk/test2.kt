package com.baidu.dk

import android.os.Parcelable

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/4/18 8:52 AM
 */

class Book(val name: String)

fun main(args: Array<String>) {
//    method1()
//    method2()

//    method4()
//    method5()
    method6()
}


private fun method1() {
    val getBook: (String) -> Book = ::Book
    val book: Book = getBook("Dive into kotlin")
    println(book.name)

    val kProperty0 = book::name
    println("输出 $kProperty0")
    println("输出 ${kProperty0.get()}")
}

fun method2() {
    val names = listOf(Book("Thinking in Java"), Book("Dive into Kotlin"))
        .map { Book::name }

    println(names)

    for (name in names) {
        println(name)
    }
    names.forEach { println(it) }
}

fun method3() {

    class Fun0 : kotlin.jvm.functions.Function0<Boolean> {
        override fun invoke(): Boolean {
            TODO("Not yet implemented")
        }
    }
}

fun method4() {

    fun foo(int: Int) {
        println(int)
    }

    listOf(1, 2, 3).forEach { foo(it) }
    listOf(1, 2, 3).forEach { }
}

fun method5() {

    fun sum(x: Int, y: Int, z: Int) = x + y + z

    // 柯里化

    // 完全展开
    fun sum3(x: Int): (Int) -> ((Int) -> Int) {
        return { y: Int ->
            { z: Int ->
                x + y + z
            }
        }
    }

    fun sum(x: Int) = { y: Int ->
        { z: Int -> x + y + z }
    }

    val sum = sum(1)(2)(3)
    println("sum $sum")


    val sum3 = sum3(1)(2)(3)
    println("sum3 $sum3")

    fun sum4(x: Int) = { y: Int ->
        { z: Int, s: String ->
            println(s)
            z + y + x

        }
    }

    val sum4 = sum4(1)(2)(3, "参数2")
    println("sum4 $sum4")
}

fun method6() {
    // 这是啥意思
    val closedRange = "abc".."xyz"
    println(closedRange.start)
    println("toString ${closedRange.toString()}")
    println("toString ${1..3}")


    println("xxx ${"kot" in closedRange}")

    println(closedRange)

    println("x ${"x" in "ab".."xy"}")
    println("y ${"y" in "ab".."xy"}")
    println("z ${"z" in "ab".."xy"}")

//    for(s in "abc".."xyz"){
//
//    }

    for (i in 1..10) {
        print("$i \t")
    }
    println()

    println("in ${"a" in listOf("a", "b", "c")}")

    "a" !in listOf("a", "b", "c")
}


fun method7() {
    val comparator1 = object : Comparator<String> {
        override fun compare(o1: String?, o2: String?): Int {
            return when {
                o1 == null -> -1
                o2 == null -> 1
                else -> o1.compareTo(o2)
            }
        }
    }

    val comparator = Comparator<String> { o1, o2 ->
        when {
            o1 == null -> -1
            o2 == null -> 1
            else -> o1.compareTo(o2)
        }
    }
}

class A {


}

data class B(var str: String) : Parcelable {
    var int: Int = 2


    override fun describeContents(): kotlin.Int {
        TODO("Not yet implemented")
    }


    override fun writeToParcel(dest: android.os.Parcel?, flags: kotlin.Int) {
        val tmp = dest!!
        str = dest.readString()!!
        int = dest.readInt()
    }


}



