package com.example.kanbanboards.profile.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.kanbanboards.R
import com.example.kanbanboards.core.BaseFragment

class ProfileFragment: BaseFragment<ProfileViewModel>(R.layout.fragment_profile) {

    override val viewModelClass: Class<ProfileViewModel> = ProfileViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.emailTextView)
        view.findViewById<View>(R.id.signOutButton).setOnClickListener {
            viewModel.signOut()
        }
        view.findViewById<View>(R.id.backButton).setOnClickListener {
            viewModel.goBack()
        }
        viewModel.observe(this) {
            it.show(textView)
        }
        viewModel.init(savedInstanceState == null)
    }
}