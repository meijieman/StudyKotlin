package com.example.studykotlin

import android.view.View

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/29 下午10:59
 */


interface OnResult {
    fun result(str: String)
}


class Biz {
    val mListener: OnResult? = null

    fun work(listener: OnResult?) {

        println("start work")
        try {
            listener?.result("start")
        } catch (e: Exception) {
            println("发生异常了 $e")
        }

//        try {
//            listener?.result("end")
//        } catch (e: Exception) {
//            println("发生异常了 $e")
//        }

        wrapper("什么鬼") {
            listener?.result("end")
        }

        println("end work")
    }

    fun work2(result: (String) -> Unit) {

        result("2 start")


        result("2 end")
    }

    fun work3(result: ((String) -> Unit)?) {
        result?.invoke("3 start")

        result?.invoke("3 end")
    }

}

fun wrapper(errMsg: String?, wrapper: () -> Unit) {
    try {
        wrapper()
    } catch (e: Exception) {
        println("wrapper 发生异常了 $errMsg")
    }
}

fun main() {
    val biz = Biz()

    biz.work(object : OnResult {
        override fun result(str: String) {
            println("收到消息了 $str")
            throw RuntimeException("皮一下")
        }
    })

    println("------")
    biz.work2 {
        println(it)
    }
    println("------")

    biz.work3(null)
    println("------")

    biz.work3 {
        println(it)
    }

}

fun test() {
    val btn = Btn()
    btn.setOnClickListener {

        println()
    }

    Btn2().setOnClickListener(View.OnClickListener {
        println()

    })

    Btn3().setOnClickListener {
        println()
    }

    // 说明 java 版的 setOnClickListener 的参数是一个函数变量而非类变量
}


class Btn2 {
    private var mListener: View.OnClickListener? = null

    fun setOnClickListener(l: View.OnClickListener?) {
        mListener = l
    }
}

class Btn3 {
    private var mListener: (() -> Unit)? = null

    fun setOnClickListener(l: () -> Unit) {
        mListener = l
    }
}