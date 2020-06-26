package com.example.studykotlin.delegate.factory

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午11:12
 */
class Logger {
    // 使用委托工厂类
    var target: String by LoggerDelegateFactory()
}

// 委托工厂类
class LoggerDelegateFactory {
    // provideDelegate 委托工厂基于此方法
    operator fun provideDelegate(thisRef: Logger, prop: KProperty<*>):
            ReadWriteProperty<Logger, String> {
        return LoggerDelegate()
    }
}

// 委托类, 继承了 ReadWriteProperty
class LoggerDelegate : ReadWriteProperty<Logger, String> {

    private var value = "file"

    override fun getValue(thisRef: Logger, property: KProperty<*>): String {
        return value
    }

    override fun setValue(thisRef: Logger, property: KProperty<*>, value: String) {
        this.value = value
    }

}

fun main() {
    val logger = Logger()
    println(logger.target)

    logger.target = "db"
    println(logger.target)

}
