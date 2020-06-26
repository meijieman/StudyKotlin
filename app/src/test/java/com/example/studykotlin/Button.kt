package com.example.studykotlin

class Button(var text: String, val width: Int, height: Int) {
    // 构造函数中的 text 为可变成员变量，width 为不可变成员变量，height 为初始化参数

    val processedHeight: Int

    init {
        processedHeight = if (height > 0) height else 0
    }
}