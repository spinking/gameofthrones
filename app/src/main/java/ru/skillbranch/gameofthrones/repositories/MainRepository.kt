package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.skillbranch.gameofthrones.data.network.IHousesApi
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val houseApi: IHousesApi
) : IMainRepository {
    override fun getAllHouses(page: Int, pageSize: Int): Single<List<HouseRes>> {
        return houseApi.getAllHouses(page, pageSize)
            .subscribeOn(Schedulers.io())
    }

    override fun getHouse(name: String): Single<HouseRes> {
        return houseApi.getHouse(name)
            .subscribeOn(Schedulers.io())
    }
}