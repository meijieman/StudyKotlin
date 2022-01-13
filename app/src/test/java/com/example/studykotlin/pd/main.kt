package com.example.studykotlin.pd

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/8/23 上午8:00
 */


fun main() {
    var shape: Shape = Circle()
    shape.draw()

    shape = Rectangle()
    shape.draw()

    var iVisitor: IVisitor = ZoomInVisitor()
//    iVisitor = ZoomOutVisitor()
    shape.acceptVisitor(iVisitor)


}
