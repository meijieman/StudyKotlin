package com.example.studykotlin.annotation

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 上午10:59
 */
@Bean
class Person @BeanConstructor constructor() {

    @BeanProperty
    var age: Int = 0
        @BeanAccessor get() = field

    @BeanMethod
    fun sayHello(message: String) {
        println("hello $message")

    }
}