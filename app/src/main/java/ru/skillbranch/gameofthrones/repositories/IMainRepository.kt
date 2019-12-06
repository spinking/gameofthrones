package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IMainRepository {
    fun getAllHouses(page: Int, pageSize: Int) : Single<List<HouseRes>>
    fun getHouse(name: String) : Single<HouseRes>
}