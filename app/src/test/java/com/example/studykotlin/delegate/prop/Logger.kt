package com.example.studykotlin.delegate.prop

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午9:37
 */
class Logger {

    // 属性委托，默认是线程安全的
    // 该属性被委托给 Delegate 类的对象
    var logLevel: Int by Delegate()
}