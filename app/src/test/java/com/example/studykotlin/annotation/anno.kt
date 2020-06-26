package com.example.studykotlin.annotation

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 上午11:52
 */


annotation class Bean
annotation class BeanConstructor
annotation class BeanProperty
annotation class BeanAccessor
annotation class BeanMethod

// 添加注解参数
annotation class Bean2(val name: String)


// 注解目标
class User(@get:BeanAccessor val name: String) // 该注解的目标是 getter 访问提

// BeanAccessor，BeanMethod 两个注解的目标都是 get
var age: Int = 0
    @get:[BeanAccessor BeanMethod] get() = field


