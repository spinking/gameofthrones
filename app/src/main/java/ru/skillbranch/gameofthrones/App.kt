package ru.skillbranch.gameofthrones

import android.app.Application

class App: Application() {

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}