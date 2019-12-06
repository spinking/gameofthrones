package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IHouseRepository {
    fun getCharacter(id: Int) : Single<CharacterRes>

}
