package com.hai.yun.mydatabinding_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hai.yun.mydatabinding_1.ui.mainactivity2.MainActivity2Fragment

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainActivity2Fragment.newInstance())
                .commitNow()
        }
    }

}
