package com.example.kanbanboards.core

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

interface ProvideDatabase {

    fun database(): DatabaseReference

    class Base: ProvideDatabase {

        init {
            Firebase.database(DATABASE_URL).setPersistenceEnabled(true)
        }

        override fun database(): DatabaseReference {
            return Firebase.database(DATABASE_URL).reference.root
        }

        companion object {
            private const val DATABASE_URL = "https://kanban-boards-3eaf3-default-rtdb.europe-west1.firebasedatabase.app"
        }
    }
}