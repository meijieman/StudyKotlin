package com.example.studykotlin.delegate.prop

import kotlin.reflect.KProperty

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/14 上午9:38
 */
class Delegate {

    private var logLevel = -1

    // 委托 Getter 访问器
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): Int {
        println("delegate getter thisRef $thisRef, prop $prop")
        return logLevel
    }

    // 委托 Setter 访问器
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: Int) {
        logLevel = value
        println("delegate setter")
    }

}