package com.example.kanbanboards.core

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

interface Communication<T: Any> {

    interface Update<T: Any>{
        fun update(source: T)
    }

    interface Observe<T: Any> {
        fun observe(owner: LifecycleOwner, observer: Observer<T>) = Unit
    }

    interface Mutable<T: Any>: Update<T>, Observe<T>

    abstract class Abstract<T: Any>(
        private val liveData: MutableLiveData<T> = SingleLiveEvent()
    ): Mutable<T> {
        override fun update(source: T) {
            liveData.value = source
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            liveData.observe(owner, observer)
        }
    }
}

class SingleLiveEvent<T>: MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    override fun setValue(value: T) {
        mPending.set(true)
        super.setValue(value)
    }
}