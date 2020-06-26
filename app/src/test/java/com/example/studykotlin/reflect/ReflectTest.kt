package com.example.studykotlin.reflect

import org.junit.Test
import kotlin.reflect.*

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 下午5:46
 */

/*
kotlin 使用反射 api 需要添加依赖
    implementation 'org.jetbrains.kotlin:kotlin-reflect:1.3.72'

 */

class Person {

    var age: Int = 0

    fun sayHello(message: String) {
        println("hello $message")
    }
}

// 顶层函数
fun isOdd(x: Int): Boolean = x % 2 != 0
// 简写
// fun isOdd(x: Int) = x % 2 != 0

// 顶层属性
var x = 2

class User(val name: String)

class ReflectTest {

    @Test
    fun test() {
        // 方法 1
        val clazz: KClass<Person> = Person::class

        // 方法 2
        val person = Person()
        val clazz2: KClass<Person> = person.javaClass.kotlin

        println(clazz.qualifiedName)
        println(clazz2.simpleName)

    }

    @Test
    fun test1() {
        val sayHello: KFunction<Unit> = Person::sayHello
        println("sayHello $sayHello")

        // KFunction2 类型实际不存在于任何类库中，在编译代码时由编译器根据方法的参数列表合返回值自动生成的
        val sayHello2: KFunction2<Person, String, Unit> = Person::sayHello
        println("sayHello2 $sayHello2")
        val person = Person()
        sayHello2.invoke(person, "major")

        val sayHello3 = Person::sayHello
        println("sayHello3 $sayHello3")
        sayHello3.invoke(person, "yun")

    }

    @Test
    fun test2() {
        // 顶层函数的反射
        val odd = ::isOdd
//        val odd: KFunction1<Int, Boolean> = ::isOdd
        println(odd.invoke(3))
    }

    @Test
    fun test3() {
        val person = Person()
        val ageRef: KMutableProperty1<Person, Int> = Person::age
        ageRef.set(person, 28)

        println(ageRef.get(person))
        println(person.age)

    }

    @Test
    fun test4() {
        val xRef: KMutableProperty0<Int> = ::x
        xRef.set(3)
        println(xRef.get())
    }

    @Test
    fun test5() {
        // KCallable 类型是 KFunction 和 KProperty 类型的父类型，所以既可以用于获取方法，也可以用户获取属性值
        val sayHelloCallable: KCallable<Unit> = Person::sayHello
        val ageCallable: KCallable<Int> = Person::age

        val person = Person()
        sayHelloCallable.call(person, "bye")
        val age: Int = ageCallable.call()

    }

    @Test
    fun test6() {
        // 反射获取构造器
        val personConstructor = ::Person
        val person1 = personConstructor.invoke()
        person1.sayHello("zxxx")

    }

    @Test
    fun test7() {
        val userConstructor: KFunction1<String, User> = ::User
        val user = userConstructor.invoke("major")
        val user1 = userConstructor("yun")

        println(user.name)
        println(user1.name)
    }

    @Test
    fun test8() {
        val word = "Hello World"
        // 获得 replace 方法
        // 因为有多个 replace 方法，所以需要表明方法的类型为 (String, String, Boolean) -> String
        val replaceRef: (String, String, Boolean) -> String = word::replace

        println(replaceRef("hello", "good", true))

        // 获取 length 属性
        val length = word::length
        println(length.get())

    }
}













