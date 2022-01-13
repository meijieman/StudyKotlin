package com.example.studykotlin.pd

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/8/23 上午7:57
 */
class Circle : Shape {

    override fun draw() {
        println("绘制圆形")
    }

    override fun acceptVisitor(visitor: IVisitor) {
        visitor.visit(this)
    }
}