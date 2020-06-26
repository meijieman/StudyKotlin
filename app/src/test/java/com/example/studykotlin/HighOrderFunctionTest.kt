package com.example.studykotlin

import org.junit.Test
import kotlin.concurrent.thread

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/22 下午12:45
 */

// 高阶函数
var inc: (Int) -> Int = fun(x: Int): Int {
    return x + 1
}


class HighOrderFunctionTest {


    @Test
    fun test() {

        println(inc(2))

        // :: 为反射 api 中的操作符
        val incRef: (Int) -> Int = inc

        println(incRef(8))
    }

    @Test
    fun test2() {

        val incRef = ::inc
        println(incRef())
        println(incRef)
    }

    val inc = fun(x: Int): Int {
        return x + 1
    }

    val dec = fun(x: Int): Int {
        return x - 1
    }

    // 高阶函数，参数为函数类型
    fun apply100(f: (Int) -> Int): Int {
        return f(100)
    }

    @Test
    fun test3() {
        println(apply100(inc))

        println(apply100(dec))
    }


    // 函数作为返回值
    fun handle(bizType: String): (Int) -> String {

        fun handle1(x: Int): String {
            // doSomething

            return "over $x"
        }

        fun handle2(x: Int): String {

            return "aha $x"
        }

        if ("over" == bizType) {
            return ::handle1
        }

        return ::handle2
    }

    @Test
    fun test4() {
        val handle: (Int) -> String = handle("666")
        val result: String = handle(22)

        println("handle $handle, result $result")
    }

    // 匿名函数
    fun getAnonymousFunction(): (Int, Int) -> Int {
        return fun(x: Int, y: Int): Int {
            return x + y
        }
    }


    /*
    lambda 表达式合匿名函数的区别
    1. lambda 最后一句语句的执行结果会自动返回，而匿名函数需加入 return 语句
    2. lambda 无法声明返回值类型，而匿名函数需要声明
    3. 如果可以从当前上下文推出参数类型，lambda 的参数类型可以省略，匿名函数不支持这种写法
    4. kotlin 支持自执行的 lambda（在定义的同时进行调用），但是不支持自执行的匿名函数
    5. lambda 支持在参数上使用结构语法，而匿名函数不支持这样做
     */

    /*
    如果参数列表最后一个参数是函数类型，需要传递到参数的实参为 lambda 表达式，则 kotlin 允许将该 lambda 提取到参数列表的小括号外。
    如果参数列表只有一个函数类型参数，将 lambda 提取到括号外之后，括号可以省略

     */

    // 用 return 指定 lambda 返回的作用域
    fun traverse(list: List<Int>, f: (Int) -> String) {
        for (item in list) {
            println("应用 $item, 结果为 ${f(item)}")
        }
    }

    @Test
    fun test5() {
        traverse(listOf(1, 2, 3)) {
            if (it % 2 == 0) {
//                return@traverse "偶数"
                "偶数"
            } else {
                return@traverse "奇数"
            }
        }
    }

    // inline 内联函数，以空间换取时间来提高程序的执行效率。
    // 内联函数不能包含任何本地函数或函数表达式
    // noinline 取消内联

    inline fun reduce(list: List<Int>, noinline f: (Int, Int) -> Int): Int {
        var result = 0
        for (i in list) {
            result = f(i, result)
        }

        return result
    }

    @Test
    fun test6() {
        val reduce = reduce(listOf(1, 3, 5)) { a, b ->
            a + b
        }

        println(reduce)

    }


    /* 本地返回与非本地返回
    调用函数时，如果该函数包含 return 语句，程序执行到该函数时回推出该函数并返回到调用处，这种方式成为本地返回（或局部返回）
    而内联函数由于是直接被复制到调用处，所以调用 return 语句时可以直接退出调用处，这种方式被称为非本地返回（或非局部返回）

     */

    inline fun traverse2(list: List<Any>, f: (Any) -> Unit) {
        for (item in list) {
            println("apply $item")
            f(item)
        }
    }

    @Test
    fun test7() {
        println("before invoke inline")
        traverse2(listOf(1, 2, 3)) {
            if (it == 2) {
                return
            }
        }
        println("after invoke inline")

    }

    // crossinline 防止在函数类型掺乎的内部使用 return
    inline fun applyList(list: List<Int>, crossinline f: (Int) -> Unit) {
        thread {
            for (item in list) {
                f(item)
            }
        }
    }

    @Test
    fun test8() {
        applyList(listOf(1, 2, 3)) {
            if (it % 2 == 0) {
                // 以下会报错
//                return
            }

            println("xxx")
        }
    }

    /* 尾递归函数
    尾递归函数可以将递归函数的调用过程优化为循环。
    不是所有的函数都能被声明为尾递归函数。
    尾递归函数要求：函数的最后一个语句只能是调用该函数自身的语句，语句中不能出现任何运算符。
    添加 tailrec 关键字可以声明一个尾递归函数，编译器会对其进行优化

     */

    tailrec fun factorialTail(n: Int, result: Int = 1): Int {
        if (n == 1) {
            return result;
        }

        return factorialTail(n - 1, result * n);
    }

    @Test
    fun test9() {
        val factorialTail = factorialTail(9)
        println(factorialTail)
    }
}