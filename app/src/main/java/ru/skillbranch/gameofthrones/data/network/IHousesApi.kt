package ru.skillbranch.gameofthrones.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IHousesApi {

    @GET("houses")
    fun getAllHouses(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ) : Single<List<HouseRes>>

    @GET("houses")
    fun getHouses(
        @QueryMap map: Map<String, String>
    ) : Single<List<HouseRes>>

    @GET("characters/{id}")
    fun getCharacter(
        @Path("id") id: String
    ): Single<CharacterRes>

    @GET("houses")
    fun getHouse(
        @Query("name") name: String
    ) : Single<HouseRes>
}