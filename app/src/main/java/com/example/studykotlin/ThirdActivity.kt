package com.example.studykotlin

import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @desc: TODO
 * @author: Major
 * @since: 2020/4/24 22:03
 */
class ThirdActivity :AppCompatActivity(){

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message?) {

        }
    }

    val h3 = Handler(fun(abc: Message?): Boolean {

        return false
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(ContextProvider.sContext, "", Toast.LENGTH_LONG).show()

    }
}