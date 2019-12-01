package ru.skillbranch.gameofthrones.presentations.stark

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.skillbranch.gameofthrones.presentations.BasePresenter
import ru.skillbranch.gameofthrones.repositories.HouseRepository
import timber.log.Timber
import kotlin.collections.HashMap

@InjectViewState
class StarkPresenter(
    private val houseRepository: HouseRepository
) : BasePresenter<IStarkView>() {
    /*fun updateHouses(array: List<String>) {
        houseRepository.getAllHouses(setQuery(array))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showHouses(it.map { it.words })
            }, {
                Timber.e(it)
            }).connect()
    }*/

    fun updateHouses(array: List<String>) {
        houseRepository.getAllHouses2()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showHouses(it)
            }, {
                Timber.e(it)
            }).connect()
    }

    private fun setQuery(list: List<String>) : Map<String, String> {
        val res = HashMap<String, String>()
        for (i in list) {
            res.put("name", i)
        }
        return res
    }
}