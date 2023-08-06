package com.example.kanbanboards.login

import com.example.kanbanboards.core.Core
import com.example.kanbanboards.core.Module
import com.example.kanbanboards.login.data.LoginCloudDataSource
import com.example.kanbanboards.login.data.LoginRepository
import com.example.kanbanboards.login.presentation.LoginCommunication
import com.example.kanbanboards.login.presentation.LoginViewModel

class LoginModule(private val core: Core): Module<LoginViewModel> {

    override fun viewModel(): LoginViewModel {
        return LoginViewModel(
            LoginRepository.Base(LoginCloudDataSource.Base(core)),
            core.provideDispatchersList(),
            core.manageResource(),
            LoginCommunication.Base(),
            core.navigation()
        )
    }
}