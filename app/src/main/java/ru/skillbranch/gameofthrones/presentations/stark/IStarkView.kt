package ru.skillbranch.gameofthrones.presentations.stark

import com.arellomobile.mvp.MvpView
import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IStarkView: MvpView {
    fun showHouses(houses: List<HouseRes>)
}