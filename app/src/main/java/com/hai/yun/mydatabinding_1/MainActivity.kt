package com.hai.yun.mydatabinding_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.hai.yun.mydatabinding_1.data.Student
import com.hai.yun.mydatabinding_1.data.User
import com.hai.yun.mydatabinding_1.databinding.ActivityMainBinding
import com.hai.yun.mydatabinding_1.lifecycles.MyObserver
import com.hai.yun.mydatabinding_1.livedata.CustomLiveData
import com.hai.yun.mydatabinding_1.livedata.ShareLiveData
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {



    lateinit var user: User;

    @Inject
    lateinit var student:Student
    var count = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val dataBind: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //绑定生命周期
        dataBind.lifecycleOwner = this;
        //获得ViewModel
        user = ViewModelProviders.of(this).get(User::class.java)

        //绑定到布局
        dataBind.user = user;
        student.name="小孩=================="
        println(student.name)
    }


    fun update(view: View) {
        Log.i("tag", "哈哈哈哈=====")
        user.checked.value = 1
        user.userName.value = "傻子"


        val intent = Intent(this, NavgationActivity::class.java)
        startActivity(intent);
//        ShareLiveData.Share.obj.setValue("单例模式修改")
        ShareLiveData.Share.singleton.setValue("单例模式修改")


    }
}
