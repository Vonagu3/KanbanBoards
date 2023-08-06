package com.example.kanbanboards.profile.presentation

import com.example.kanbanboards.core.Communication

interface ProfileCommunication: Communication.Mutable<ProfileUiState> {
    class Base: Communication.Abstract<ProfileUiState>(), ProfileCommunication
}