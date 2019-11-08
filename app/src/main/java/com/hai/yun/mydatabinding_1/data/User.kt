package com.hai.yun.mydatabinding_1.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hai.yun.mydatabinding_1.livedata.CustomLiveData
import com.hai.yun.mydatabinding_1.livedata.ShareLiveData


class User : ViewModel() {
    val userName: MutableLiveData<String> = ShareLiveData.Share.singleton.getInstance().data
    val passWord: MutableLiveData<String> by lazy {
        CustomLiveData<String>("bbs")
    }
    val checked: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(1)
    }
}