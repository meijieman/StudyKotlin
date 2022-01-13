package com.example.studykotlin

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.jinrishici.sdk.android.JinrishiciClient
import com.jinrishici.sdk.android.factory.JinrishiciFactory
import com.jinrishici.sdk.android.listener.JinrishiciCallback
import com.jinrishici.sdk.android.model.JinrishiciRuntimeException
import com.jinrishici.sdk.android.model.PoetySentence
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main"
    }

    // new Handler()
    @SuppressWarnings("handlerLeak")
    private val handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }

    interface Test {
        fun foo(): Boolean
    }

    fun te(test: Test) {

    }
//    val test:Test = {
//
//        true
//    }

    // 区别于 foo: () -> Boolean?
    open class CC {

        //        constructor():this(null, false)
        constructor()

        constructor(foo: (() -> Boolean))

        // 在Kotlin中@JvmOverloads注解的作用就是：在有默认参数值的方法中使用@JvmOverloads注解，则Kotlin就会暴露多个重载方法。
        @JvmOverloads
        constructor(foo: Test?, aa: Boolean = false)

        @JvmOverloads
//        constructor(test: Test) : this(test::foo) {}


//        constructor() : this(null)

        open fun foo() {
        }
    }

    val c = object : CC() {
        override fun foo() {
            super.foo()
        }
    }


    val c2 = CC(fun(): Boolean {
        return false
    })

    fun use() {
        te(object : Test {
            override fun foo(): Boolean {

                return false
            }
        })

        CC(object : Test {
            override fun foo(): Boolean {

                return false
            }
        })


        CC {

            false
        }

    }

    val t = object : Test {
        override fun foo(): Boolean {

            return false
        }
    }

    // new Handler(new Handler.Callback(){})
    val h = Handler(object : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {

            return true
        }
    })

    val h2 = Handler(Handler.Callback() {

        false
    })


    val handler2 = Handler {
        when (it.what) {
            1 -> {

            }
            else -> {
                Log.d(TAG, "handler else")
            }
        }
        false
    }

    val h3 = Handler(

        fun(abc: Message?): Boolean {

            return false
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_main.text = "kotlin"

        handler.sendEmptyMessage(1)
        Log.w(TAG, "start")
        btn_update.setOnClickListener {
            // 今日诗词
            JinrishiciFactory.init(this)
            val client = JinrishiciClient.getInstance()
            client.getOneSentenceBackground(object : JinrishiciCallback {
                override fun done(poetySentence: PoetySentence) {
                    Log.w(TAG, "success ${Gson().toJson(poetySentence)}")

                    //在这里进行你的逻辑处理
                    tv_main.text = poetySentence.data.content
                }

                override fun error(e: JinrishiciRuntimeException) {
                    Log.e(TAG, "error: code = " + e.code + " message = " + e.message)
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }


}
