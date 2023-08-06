package com.example.kanbanboards.main

import com.example.kanbanboards.core.Core
import com.example.kanbanboards.core.Module

class MainModule(private val core: Core): Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel(core.navigation())
    }
}