package com.example.kanbanboards.core

import androidx.lifecycle.ViewModel

interface Module<T: ViewModel> {
    fun viewModel(): T
}