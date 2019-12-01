package ru.skillbranch.gameofthrones.di


import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.skillbranch.gameofthrones.App
import ru.skillbranch.gameofthrones.MainActivity
import ru.skillbranch.gameofthrones.ui.MainFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, PresenterModule::class,
    PreferencesModule::class, RepositoryModule::class, InteractorModule::class])
interface AppComponent {
    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    interface ComponentProvider {
        val appComponent: AppComponent
    }

    //activity
    fun inject(activity: MainActivity)
    //fun inject(activity: SplashActivity)

    //fragment
    fun inject(fragment: MainFragment)
    //fun inject(fragment: BaseGoogleMap)



    //presenterRestore
    //fun inject(presenter: FilterPresenter)

}