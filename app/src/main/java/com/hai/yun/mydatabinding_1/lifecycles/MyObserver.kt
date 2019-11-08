package com.hai.yun.mydatabinding_1.lifecycles

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class MyObserver : LifecycleObserver {
    private lateinit var timer: Timer

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun connectListener() {

    }


    fun SendTask(context: Context) {
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runBlocking {
                    launch(Dispatchers.Main) {
                        println("===" + Thread.currentThread().id)
                        Toast.makeText(context, "xxxx", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }, 5000)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun closeTimer() {
        timer.cancel();
        println("取消了=====================")
    }
}