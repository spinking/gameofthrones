package ru.skillbranch.gameofthrones.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.gameofthrones.presentations.MainPresenter
import ru.skillbranch.gameofthrones.presentations.stark.StarkPresenter
import ru.skillbranch.gameofthrones.repositories.HouseRepository
import ru.skillbranch.gameofthrones.repositories.MainRepository

@Module
class PresenterModule {
    @Provides
    fun provideStarkPresenter(
        houseRepository: HouseRepository
    ) : StarkPresenter = StarkPresenter(houseRepository)

    @Provides
    fun provideStarkPresenter(
        mainRepository: MainRepository
    ) : MainPresenter = MainPresenter(mainRepository)
}