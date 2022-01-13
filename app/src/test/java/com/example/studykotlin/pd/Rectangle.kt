package com.example.studykotlin.pd

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/8/23 上午7:58
 */
class Rectangle : Shape {

    override fun draw() {

        println("绘制矩形")

    }

    override fun acceptVisitor(visitor: IVisitor) {
        visitor.visit(this)
    }
}