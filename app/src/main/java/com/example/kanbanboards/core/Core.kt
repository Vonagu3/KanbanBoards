package com.example.kanbanboards.core

import android.content.Context
import com.example.kanbanboards.main.NavigationCommunication
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference

class Core(context: Context) : ProvideNavigation, ProvideStorage, ProvideManageResource,
    ProvideDispatchersList, ProvideDatabase {

    init {
        FirebaseApp.initializeApp(context)
    }

    private val provideDatabase = ProvideDatabase.Base()
    private val manageResource = ManageResource.Base(context)
    private val navigation = NavigationCommunication.Base()
    private val storage = Storage.Base(context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE))
    private val dispatchersList = DispatchersList.Base()

    override fun navigation(): NavigationCommunication.Mutable {
        return navigation
    }

    override fun storage(): Storage {
        return storage
    }

    override fun manageResource(): ManageResource {
        return manageResource
    }

    override fun provideDispatchersList(): DispatchersList {
        return dispatchersList
    }

    override fun database(): DatabaseReference {
        return provideDatabase.database()
    }

    companion object {
        private const val STORAGE_NAME = "KANBAN BOARDS APP DATA"
    }
}

interface ProvideNavigation {
    fun navigation(): NavigationCommunication.Mutable
}

interface ProvideStorage {
    fun storage(): Storage
}

interface ProvideManageResource {
    fun manageResource(): ManageResource
}

interface ProvideDispatchersList {
    fun provideDispatchersList(): DispatchersList
}