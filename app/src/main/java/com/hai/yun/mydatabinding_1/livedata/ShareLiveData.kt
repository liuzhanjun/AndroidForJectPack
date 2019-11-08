package com.hai.yun.mydatabinding_1.livedata

import androidx.lifecycle.MutableLiveData


class ShareLiveData<String> : MutableLiveData<String> {

    constructor(value: String) : super(value) {

    }

    public override fun postValue(value: String) {
        super.postValue(value)
    }

    public override fun setValue(value: String) {
        super.setValue(value)
    }

    //比如有个某某服务
    //在LivData对象具有观察者，并且处于STARTED或者RESUME状态会回调该方法
    override fun onActive() {
        //可以在这里为服务添加监听该数据的更新
        println("可以在这里为服务添加监听，监听数据更新")
    }

    //当LiveData对象没有任何活动的观察者时，将调用该方法。
    // 由于没有观察者在听，因此没有理由保持与服务的联系
    override fun onInactive() {
        //在这里移除掉服务的监听
        println("在这里移除掉服务的监听")
    }

    enum class Share {

        singleton {
            override fun getInstance(): Share {
                data = ShareLiveData("");
                return this;
            }
        };

        lateinit var data: MutableLiveData<String>
        abstract fun getInstance(): Share

        fun setValue(_value: String) {
            data.value = _value;
        }

        fun getValue(): String? {
            return data.value;
        }

    }
}


