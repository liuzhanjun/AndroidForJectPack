package com.hai.yun.mydatabinding_1.lifecycles

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

open class BaseActivity : Activity(), LifecycleOwner {
    private lateinit var lifecycle: LifecycleRegistry
    override fun getLifecycle(): Lifecycle {
        return lifecycle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle = LifecycleRegistry(this)
        lifecycle.currentState=Lifecycle.State.CREATED
    }

    override fun onStart() {
        super.onStart()
        lifecycle.currentState=Lifecycle.State.STARTED
    }

    override fun onResume() {
        super.onResume()
        lifecycle.currentState=Lifecycle.State.RESUMED
    }
    override fun onDestroy() {
        super.onDestroy()
        lifecycle.currentState=Lifecycle.State.DESTROYED
    }
}