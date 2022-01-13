package com.example.studykotlin.pd

/**
 * 缩小
 *
 * @author meijie05
 * @since 2020/8/23 上午8:09
 */

class ZoomInVisitor : IVisitor {

    override fun visit(s: Circle) {
        println("缩小圆形")
    }

    override fun visit(s: Rectangle) {
        println("缩小矩形")
    }

    override fun visit(s: Triggle) {
        println("缩小三角形")
    }


}