package com.hai.yun.mydatabinding_1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_navgation.*

class NavgationActivity : AppCompatActivity(), FirstFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_navgation)
        val navControoler=nav_host_fragment.findNavController();
        button2.setOnClickListener(){
            navControoler.navigate(R.id.firstFragment)

        }
        button3.setOnClickListener(){
            navControoler.navigate(R.id.thirdFragment2)
        }
        button4.setOnClickListener(){

           val action= ThirdFragmentDirections.actionThirdFragment2ToSecondFragment()
            navControoler.navigate(action)
        }
    }
}
