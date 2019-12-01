package ru.skillbranch.gameofthrones.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.gameofthrones.presentations.stark.StarkPresenter
import ru.skillbranch.gameofthrones.repositories.HouseRepository

@Module
class PresenterModule {
    @Provides
    fun provideStarkPresenter(
        houseRepository: HouseRepository
    ) : StarkPresenter = StarkPresenter(houseRepository)
}