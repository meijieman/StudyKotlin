package com.example.studykotlin.pd

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/8/23 上午7:57
 */
interface Shape {

    fun draw()

    fun acceptVisitor(visitor: IVisitor)


}