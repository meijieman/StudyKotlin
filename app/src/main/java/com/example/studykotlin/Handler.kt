package com.example.studykotlin

import android.os.Looper
import android.os.Message

/**
 * @desc: TODO
 * @author: Major
 * @since: 2020/4/24 21:56
 */
open class Handler {

    interface Callback {
        fun handleMessage(msg: Message?): Boolean
    }


    constructor(async: Boolean) : this(null, async) {}

    @JvmOverloads
    constructor(
        callback: Callback? = null,
        async: Boolean = false
    ) {
    }

    constructor(aaa:(msg:Message)->Boolean)

    @JvmOverloads
    constructor(
        looper: Looper?,
        callback: Callback?,
        async: Boolean = false
    ) {
    }

    open fun handleMessage(msg: Message?) {}
}