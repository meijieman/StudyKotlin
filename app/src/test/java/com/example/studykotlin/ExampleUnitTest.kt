package com.example.studykotlin

import org.junit.Assert.assertEquals
import org.junit.Test

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
//        bar("1")
        bar(22)
    }


    fun bar(str: Any) {

        // 安全类型转换，转换失败则返回 null
        var number: Int? = str as? Int
        println(number)

//        var number2 :Int = str as Int
//        println(number2)

    }

    @Test
    fun test2() {
        // 类型别名(需要定义在类外面) typealias 别名 = 原类型名
        var i: MyInt = 28
        println(i)
        println(i.javaClass) // 输出类型

    }

    @Test
    fun test3() {
        // 序列类型
        val seq = sequenceOf(1, 3, 5)
        for (i in seq) {
            println(i)
        }
        println(seq)

        val seq1 = generateSequence(8) {
            val i = it + 5
            if (i > 20) {
                null
            } else {
                i
            }
        }

        for (i in seq1) {
            println(i)
        }

    }

    @Test
    fun test4() {

        // immutable map
        val mapOf = mapOf(Pair("name", "major"), Pair("national", "china"), Pair("favorite", "yun"))
        println(mapOf)

        val mapOf1 = mapOf("name" to "major", "national" to "china", "favorite" to "yun")
        println(mapOf1)

        // mutable map
        val mutableMapOf = mutableMapOf("name" to "yun", "favorite" to "major")
        println(mutableMapOf)
        mutableMapOf.put("national", "china");
        println(mutableMapOf)

    }

    @Test
    fun test5() {
        val foo2 = foo2()
        println("first ${foo2.first}, second ${foo2.second}")

        val foo3 = foo3()
        println("${foo3.first} ${foo3.second} ${foo3.third}")

    }

    // 返回两个值
    fun foo2(): Pair<Int, String> {
        return Pair(28, "major")
    }

    // 返回三个值
    fun foo3(): Triple<Int, String, String> {
        return Triple(28, "major", "yun")
    }

    @Test
    fun test6() {
        val button = Button("click", 200, -20)
        println("${button.processedHeight}, ${button.text}, ${button.width}")
    }

    @Test
    fun test7() {
        val student = Student()
        student.height(175)

        // fix 方法
        student height 180

        println(student.height)
    }

    open class Parent
    class Child : Parent()

    // 泛型类
    class Holder<T>(var obj: T)

    // 将协变（Covariant）应用在类上被成为『在声明处协变』
    // 在类型参数前面加上 out，变量 obj 只能声明为 val
    class CovariantHolder<out T>(val obj: T)


    @Test
    fun test8() {
        val childHolder = Holder(Child())
        val parentHolder = Holder(Parent())

//        parentHolder = childHolder


        val strCovariant = CovariantHolder("hello")
        // 基于协变定义
        var anyCovariant: CovariantHolder<Any> = strCovariant
        val obj: Any = anyCovariant.obj;
    }

    // 逆变(Contravarint) 逆变的类型参数只能用于输入类型，协变只能作为方法的参数类型
    class ContravarintHolder<in T>(obj: T) {
        fun test(param: T) {
            println(param)
        }
    }

    @Test
    fun test9() {
        var anyContravarint = ContravarintHolder<Any>(10)
        // 基于逆变定义
        var strContravarintHolder: ContravarintHolder<String> = anyContravarint
        strContravarintHolder.test("hello")

    }

    // 在使用处协变
    fun covariantFun(holder: Holder<out Number>) {
        val obj: Number = holder.obj
        println("$obj, ${obj.javaClass}")
        // 此处不知道 obj 的具体类型，只知道是 Number 类型，故无法赋值
//        holder.obj = 5
        println(holder.obj.toByte())
    }

    @Test
    fun test10() {
        covariantFun(Holder(2.2))
        covariantFun(Holder((28)))
    }

    // 逆变
    fun contravarintFun(holder: Holder<in Number>) {
        holder.obj = 5
        println(holder.obj)
//        println(holder.obj.toByte())
        val any: Any? = holder.obj
    }

    @Test
    fun test11() {
        contravarintFun(Holder(2.2))
    }

    /*
    我的理解：
        协变对应 java 泛型中的 extend，限定类型的上限
        逆变对应 java 泛型中的 super，限定类型的下限
     */


    // 星号投影，在使用时回自动将类型限制为 Any 类型或 Nothing 类型。
    fun extract(holder: Holder<*>) {
        var any: Any? = holder.obj
        println(any)
//        any.toInt()
        any = 5
        println(any)
    }

    @Test
    fun test12() {
        extract(Holder(28))
    }

    fun <T> fillList(list: MutableList<T>, size: Int, clazz: Class<T>) {
        for (i in 1..size) {
            val obj = clazz.newInstance()
            list.add(obj)
        }
        println("fillList $list")
    }

    // 内联函数消除类型擦除的影响
    // 内联函数在编译时会被复制到该函数的调用处，此时内联函数的类型形参也会被调用处的真实类型替代，所以内联函数不受类型擦除的影响。
    inline fun <reified T> fillList(list: MutableList<T>, size: Int) {
        for (i in 1..size) {
            val obj = T::class.java.newInstance()
            list.add(obj)
        }

        println(list)
    }

    @Test
    fun test13() {
        fillList(mutableListOf(), 4, String::class.java)

        fillList<String>(mutableListOf(), 3)

    }

    /*
    String.javaClass 和 String::class.java 区别

     */


}

typealias MyInt = Int
