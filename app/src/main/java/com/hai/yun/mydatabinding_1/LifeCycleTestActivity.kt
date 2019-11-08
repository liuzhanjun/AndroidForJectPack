package com.hai.yun.mydatabinding_1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.hai.yun.mydatabinding_1.lifecycles.BaseActivity
import com.hai.yun.mydatabinding_1.lifecycles.MyListener
import com.hai.yun.mydatabinding_1.lifecycles.MyObserver

class LifeCycleTestActivity : BaseActivity() {

    private lateinit var lister: MyListener
    lateinit var obserabls: MyObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_lifecycle_test)
        obserabls = MyObserver()
//        this.lifecycle.addObserver(obserabls);
        lister=MyListener(this.lifecycle)
    }
    //按钮触发事件
    fun TestLifeCycle(view: View) {
//        obserabls.SendTask(this);
        lister.SendTask(this)

    }
}