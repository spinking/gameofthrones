package ru.skillbranch.gameofthrones.data.network

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IHousesApi {
    @GET("houses/")
    fun getHouses(
        @QueryMap map: Map<String, String>
    ) : Single<List<HouseRes>>

    @GET("houses/")
    fun getHouses2() : Single<List<HouseRes>>
}