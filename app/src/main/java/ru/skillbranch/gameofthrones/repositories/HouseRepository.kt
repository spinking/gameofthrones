package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.skillbranch.gameofthrones.data.network.IHousesApi
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import javax.inject.Inject


class HouseRepository @Inject constructor(
    private val houseApi: IHousesApi
) : IHouseRepository {

    override fun getCharacter(id: Int): Single<CharacterRes> {
        return houseApi.getCharacter(id.toString())
            .subscribeOn(Schedulers.io())
    }
}