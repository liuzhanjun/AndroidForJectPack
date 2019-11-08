package com.hai.yun.mydatabinding_1.lifecycles

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class MyListener(var mLifecycle: Lifecycle) : LifecycleObserver {
    init {
        mLifecycle.addObserver(this)
    }
    private  var timer: Timer? =null;
    fun SendTask(context: Context) {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runBlocking {
                    launch(Dispatchers.Main) {
                        println("===" + mLifecycle.currentState)
                        //对于一些不会立即cancel或者close的组件可以加入此判断
//                        if (mLifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
//                            Toast.makeText(context, "xxxx", Toast.LENGTH_SHORT).show()
//                        }
                        Toast.makeText(context, "xxxx", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }, 5000)

    }
    //当注册到的某个组件的生命周期到达该生命周期会自动调用此方法
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun closeTimer() {
        timer?.cancel();
        println("取消了=====================")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destory() {
        println("destroy====================")
        //控件的生命周期管理移除监听
        mLifecycle.removeObserver(this)
    }
}