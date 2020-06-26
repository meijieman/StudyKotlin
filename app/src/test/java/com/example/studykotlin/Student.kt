package com.example.studykotlin

class Student {

    var height: Int = 0

    // 如果一个方法被 infix 修饰，则调用该方法时可以省略点符号和小括号。使调用类似于二元操作符
    infix fun height(height: Int) {
        this.height = height
    }
}