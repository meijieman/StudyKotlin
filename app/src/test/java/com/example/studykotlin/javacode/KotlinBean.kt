package com.example.studykotlin.javacode

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/2 上午7:12
 */

class KotlinBean(var name: String) {

    // 伴生对象
    companion object {
        @JvmField
        var companionProperty = 1

        @JvmStatic
        fun fooByAnno() {
            println("使用 @JvmStatic 修饰的伴生对象方法")
        }

        fun foo() {
            println("伴生对象方法")
        }
    }

    var isAdult: Boolean = false

    @JvmField
    var username = "name"

    // 使用 @JvmOverloads 注解的方法会自动生成重载方法
    @JvmOverloads
    fun foobar(a: String, b: Int = 0, c: String = "c") {
        println("a = $a b = $b c = $c")
    }
}