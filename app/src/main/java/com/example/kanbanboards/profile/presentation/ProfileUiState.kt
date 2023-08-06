package com.example.kanbanboards.profile.presentation

import android.widget.TextView
import com.example.kanbanboards.R

interface ProfileUiState {

    fun show(textView: TextView)

    class Base(
        private val email: String,
        private val name: String
    ): ProfileUiState {

        override fun show(textView: TextView) {
            textView.text = textView.context.getString(R.string.my_email, name, email)
        }
    }
}