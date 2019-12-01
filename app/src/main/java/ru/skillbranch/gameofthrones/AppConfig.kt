package ru.skillbranch.gameofthrones

import android.app.Application
import ru.skillbranch.gameofthrones.di.AppComponent
import timber.log.Timber
import ru.skillbranch.gameofthrones.di.DaggerAppComponent

class AppConfig: Application(), AppComponent.ComponentProvider {

    override lateinit var appComponent: AppComponent
    companion object {
        lateinit var INSTANCE: AppConfig
            private set
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        INSTANCE = this
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }
}