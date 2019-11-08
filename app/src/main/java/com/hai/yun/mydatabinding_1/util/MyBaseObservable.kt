package com.hai.yun.mydatabinding_1.util

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry

open class MyBaseObservable : Observable {
    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry();
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback);
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback);
    }

    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyChange(this, fieldId)
    }
}