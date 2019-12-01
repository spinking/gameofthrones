package ru.skillbranch.gameofthrones.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.gameofthrones.data.network.IHousesApi
import ru.skillbranch.gameofthrones.repositories.HouseRepository
import ru.skillbranch.gameofthrones.repositories.IHouseRepository

@Module
class RepositoryModule {
    @Provides
    fun provideHouseRepository(
        houseApi: IHousesApi
    ) : IHouseRepository = HouseRepository(houseApi)
}