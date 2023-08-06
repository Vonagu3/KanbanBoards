package com.example.kanbanboards.profile

import com.example.kanbanboards.core.Core
import com.example.kanbanboards.core.Module
import com.example.kanbanboards.profile.presentation.ProfileCommunication
import com.example.kanbanboards.profile.presentation.ProfileViewModel

class ProfileModule(private val core: Core): Module<ProfileViewModel> {
    override fun viewModel(): ProfileViewModel {
        return ProfileViewModel(ProfileCommunication.Base(), core.navigation())
    }
}