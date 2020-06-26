package com.example.studykotlin.dsl

import org.junit.Test

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/26 上午9:23
 */
class AlertDialog {
    var title: String = ""
    var message: String = ""

    fun title(title: String): AlertDialog {
        this.title = title
        return this
    }

    fun message(message: String): AlertDialog {
        this.message = message
        return this
    }

    fun show() {
        println("[AlertDialog] title $title, message $message")
    }
}

class AlertDialog2 {
    var title: String = ""
    var message: String = ""

    // infix 中缀表达式
    infix fun title(title: String): AlertDialog2 {
        this.title = title
        return this
    }

    infix fun message(message: String): AlertDialog2 {
        this.message = message
        return this
    }

    fun show() {
        println("[AlertDialog2] title $title, message $message")
    }
}

class DslTest2 {
    @Test
    fun test() {
        val dialog = AlertDialog().title("info").message("hello world")
        dialog.show()
    }

    @Test
    fun test1() {
        val dialog2 = AlertDialog2() title "标题" message "消息内容"
        dialog2.show()
    }
}