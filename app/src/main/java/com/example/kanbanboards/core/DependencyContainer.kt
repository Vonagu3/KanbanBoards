package com.example.kanbanboards.core

import androidx.lifecycle.ViewModel
import com.example.kanbanboards.login.LoginModule
import com.example.kanbanboards.login.presentation.LoginViewModel
import com.example.kanbanboards.main.MainModule
import com.example.kanbanboards.main.MainViewModel
import com.example.kanbanboards.profile.ProfileModule
import com.example.kanbanboards.profile.presentation.ProfileViewModel

interface DependencyContainer {

    fun module(className: Class<out ViewModel>): Module<out ViewModel>

    class Error: DependencyContainer {
        override fun module(className: Class<out ViewModel>): Module<out ViewModel> {
            throw IllegalArgumentException("unkown className $className")
        }
    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ): DependencyContainer {
        override fun module(className: Class<out ViewModel>): Module<out ViewModel> {
            return when(className) {
                MainViewModel::class.java -> MainModule(core)
                LoginViewModel::class.java -> LoginModule(core)
                ProfileViewModel::class.java -> ProfileModule(core)
                else -> dependencyContainer.module(className)
            }
        }
    }
}