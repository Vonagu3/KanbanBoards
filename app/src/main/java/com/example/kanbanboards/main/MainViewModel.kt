package com.example.kanbanboards.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kanbanboards.core.Init
import com.example.kanbanboards.login.presentation.LoginScreen

class MainViewModel(
    private val navigationCommunication: NavigationCommunication.Mutable
): ViewModel(), NavigationCommunication.Observe, Init {

    override fun observe(owner: LifecycleOwner, observer: Observer<Screen>) {
        navigationCommunication.observe(owner, observer)
    }

    override fun init(firstRun: Boolean) {
        if (firstRun) navigationCommunication.update(LoginScreen)
    }
}