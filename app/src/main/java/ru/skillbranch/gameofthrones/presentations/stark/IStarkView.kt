package ru.skillbranch.gameofthrones.presentations.stark

import com.arellomobile.mvp.MvpView
import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IStarkView: MvpView {
    fun showCharacter(char: List<CharacterRes>)
}