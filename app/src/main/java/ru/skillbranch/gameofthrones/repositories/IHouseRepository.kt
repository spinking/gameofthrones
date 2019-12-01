package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Completable
import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IHouseRepository {
    fun getAllHouses(map: Map<String, String>) : Single<List<HouseRes>>
    fun getAllHouses2() : Single<List<HouseRes>>
}
