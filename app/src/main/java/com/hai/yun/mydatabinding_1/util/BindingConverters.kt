package com.hai.yun.mydatabinding_1.util

import android.view.View
import androidx.databinding.BindingConversion
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseMethod

object BindingConverters {
    @JvmStatic
    fun IntToBoolean(mInt: Int): Boolean {
        if (mInt == 0) {
            return false
        }
        return true;
    }


    @InverseMethod("IntToBoolean")
    @JvmStatic
    fun booleanToInt(mBoolean: Boolean): Int {
        if (!mBoolean) {
            return 0;
        }
        return 1;
    }
}