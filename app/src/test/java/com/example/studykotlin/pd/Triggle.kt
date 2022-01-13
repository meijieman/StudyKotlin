package com.example.studykotlin.pd

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/8/23 上午7:59
 */
class Triggle : Shape {

    override fun draw() {
        println("绘制三角形")
    }

    override fun acceptVisitor(visitor: IVisitor) {
        visitor.visit(this)
    }
}