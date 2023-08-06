package com.example.kanbanboards.profile.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kanbanboards.core.Communication
import com.example.kanbanboards.core.Init
import com.example.kanbanboards.login.presentation.LoginScreen
import com.example.kanbanboards.main.NavigationCommunication
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileViewModel(
    private val communication: ProfileCommunication,
    private val navigationCommunication: NavigationCommunication.Update
): ViewModel(), Init, Communication.Observe<ProfileUiState> {

    override fun observe(owner: LifecycleOwner, observer: Observer<ProfileUiState>) {
        communication.observe(owner, observer)
    }

    fun signOut() {
        Firebase.auth.signOut()
        navigationCommunication.update(LoginScreen)
    }

    override fun init(firstRun: Boolean) {
        if (Firebase.auth.currentUser == null)
            navigationCommunication.update(LoginScreen)
        else{
            val currentUser = Firebase.auth.currentUser!!
            communication.update(ProfileUiState.Base(
                currentUser.email!!,
                currentUser.displayName ?: ""
            ))
        }
    }

    fun goBack() {
        TODO("Not yet implemented")
    }
}