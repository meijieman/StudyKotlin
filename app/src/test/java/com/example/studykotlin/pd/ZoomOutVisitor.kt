package com.example.studykotlin.pd

/**
 * 缩小
 *
 * @author meijie05
 * @since 2020/8/23 上午8:09
 */

class ZoomOutVisitor : IVisitor {

    override fun visit(s: Circle) {
        println("放大圆形")
    }

    override fun visit(s: Rectangle) {
        println("放大矩形")
    }

    override fun visit(s: Triggle) {
        println("放大三角形")
    }


}