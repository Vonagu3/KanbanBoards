package com.example.kanbanboards.login.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kanbanboards.core.BaseViewModel
import com.example.kanbanboards.core.Communication
import com.example.kanbanboards.core.DispatchersList
import com.example.kanbanboards.core.Init
import com.example.kanbanboards.core.ManageResource
import com.example.kanbanboards.login.data.LoginRepository
import com.example.kanbanboards.main.NavigationCommunication

class LoginViewModel(
    private val repository: LoginRepository,
    dispatchersList: DispatchersList,
    private val manageResource: ManageResource,
    private val communication: LoginCommunication,
    private val navigation: NavigationCommunication.Update
): BaseViewModel(dispatchersList), Init, Communication.Observe<LoginUiState> {

    override fun observe(owner: LifecycleOwner, observer: Observer<LoginUiState>) {
        communication.observe(owner, observer)
    }

    override fun init(firstRun: Boolean) {
        if (firstRun) {
            if (repository.userNotLoggedIn())
                communication.update(LoginUiState.Initial)
            else
                login()
        }
    }

    fun handleResult(authResult: AuthResultWrapper) = handle({
        repository.handleResult(authResult)
    }) {
        it.map(communication, navigation)
    }

    fun login() = communication.update(LoginUiState.Auth(manageResource))
}