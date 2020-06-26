package com.example.studykotlin.delegate.prop

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午10:04
 */
class A {
    val aLazyProperty: Long by lazy {
        println("compute... ${Thread.currentThread().name}")
        Thread.sleep(3000)
        System.currentTimeMillis()
    }

    var str: String = ""

    val strLazy: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        "lazy $str"
    }
}

fun main() {
    val a = A()

    println("Hello 1, ${a.aLazyProperty}")
    println("Hello 2, ${a.aLazyProperty}")


    a.str = "kotlin"
    println("strLazy ${a.strLazy}")

}


/*

fun main() = runBlocking{
    // 延迟加载，只有只读属性可以延迟加载

    val a = A()
    val launch = GlobalScope.launch {
        println("Hello 1, ${a.aLazyProperty}")

        withContext(Dispatchers.Main) {
            println("Hello 2, ${a.aLazyProperty}")
        }
    }

    println("xxxxx")
}
*/
