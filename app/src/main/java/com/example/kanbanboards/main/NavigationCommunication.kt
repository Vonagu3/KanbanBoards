package com.example.kanbanboards.main

import com.example.kanbanboards.core.Communication

interface NavigationCommunication {

    interface Observe: Communication.Observe<Screen>

    interface Update: Communication.Update<Screen>

    interface Mutable: Observe, Update

    class Base: Communication.Abstract<Screen>(), Mutable
}