package com.example.studykotlin.pd

/**
 * 访问者模式
 *
 * @author meijie05
 * @since 2020/8/23 上午7:59
 */

interface IVisitor {

    fun visit(s: Circle)
    fun visit(s: Rectangle)
    fun visit(s: Triggle)
}
