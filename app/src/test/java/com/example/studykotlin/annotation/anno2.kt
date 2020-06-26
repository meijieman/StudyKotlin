package com.example.studykotlin.annotation

import kotlin.reflect.KClass

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 上午11:57
 */


annotation class Api(val version: String = "1")

// 用注解作为注解的参数类型
annotation class ApiModel(val name: String, val version: Api)

@ApiModel(name = "响应对象", version = Api("1.2"))
class Response


annotation class Closure

// 将注解应用到 lambda 上
val f = @Closure { i: Int ->
    i * 100
}


annotation class Converter(val from: KClass<*>, val to: KClass<*>)

// 用类作为注解的参数类型
@Converter(String::class, Int::class)
class String2IntConverter


annotation class NumArray(val array: IntArray)

// 用数组作为注解的参数类型
@NumArray(intArrayOf(1, 2, 3))
class A

@NumArray([1, 2, 3])
class Str1


annotation class Desc(val code: Int)

object Constant {
    const val n = 1
}
// 用常量作为注解的参数值

@Desc(code = Constant.n)
class B


