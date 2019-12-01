package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.skillbranch.gameofthrones.data.network.IHousesApi
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import javax.inject.Inject


class HouseRepository @Inject constructor(
    private val houseApi: IHousesApi
) : IHouseRepository {
    override fun getAllHouses(map: Map<String, String>) : Single<List<HouseRes>> {
        return houseApi.getHouses(map)
            .subscribeOn(Schedulers.io())
    }

    override fun getAllHouses2(): Single<List<HouseRes>> {
        return houseApi.getHouses2()
            .subscribeOn(Schedulers.io())
    }
}