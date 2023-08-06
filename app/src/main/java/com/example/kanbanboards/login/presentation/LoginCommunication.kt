package com.example.kanbanboards.login.presentation

import com.example.kanbanboards.core.Communication

interface LoginCommunication: Communication.Mutable<LoginUiState> {
    class Base: Communication.Abstract<LoginUiState>(), LoginCommunication
}