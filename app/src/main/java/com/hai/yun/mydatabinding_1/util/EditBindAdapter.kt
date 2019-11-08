package com.hai.yun.mydatabinding_1.util

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.adapters.TextViewBindingAdapter
import java.sql.Time

object EditBindAdapter {

    //如何设置控件属性的值
    @BindingAdapter("numberOfSets")
    @JvmStatic
    fun setNumberOfSets(view: EditText, value: String) {
        print("==========================")
        if (!view.text.equals(value)) {
            view.setText(value)
        }
    }

    //如何获得控件属性的值
    @InverseBindingAdapter(attribute = "numberOfSets")
    @JvmStatic
    fun getNumberOfSets(editText: EditText): String {
        return editText.text.toString()
    }

    //告诉InverseBindingAdapter何时获得控件数据变更
    @BindingAdapter("numberOfSetsAttrChanged")
    @JvmStatic
    fun setListener(view: EditText, listener: InverseBindingListener) {
        var temp: String = ""
        view.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                temp = s.toString();
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                view.setSelection(before)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().equals(temp)) {
                    return
                }
                listener.onChange();
            }

        })
    }

}