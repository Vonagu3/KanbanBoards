package com.example.kanbanboards.login.data

import com.example.kanbanboards.login.presentation.LoginCommunication
import com.example.kanbanboards.login.presentation.LoginUiState
import com.example.kanbanboards.main.NavigationCommunication
import com.example.kanbanboards.profile.presentation.ProfileScreen

interface LoginResult {

    fun map(communication: LoginCommunication, navigation: NavigationCommunication.Update)

    object Success: LoginResult {
        override fun map(
            communication: LoginCommunication,
            navigation: NavigationCommunication.Update
        ) {
            navigation.update(ProfileScreen)
        }
    }

    data class Failed(private val message: String) : LoginResult {

        override fun map(
            communication: LoginCommunication,
            navigation: NavigationCommunication.Update
        ) = communication.update(LoginUiState.Error(message))
    }
}