package ru.skillbranch.gameofthrones.presentations.stark

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.presentations.BasePresenter
import ru.skillbranch.gameofthrones.repositories.HouseRepository
import timber.log.Timber
import kotlin.collections.HashMap

@InjectViewState
class StarkPresenter(
    private val houseRepository: HouseRepository
) : BasePresenter<IStarkView>() {


    private fun setQuery(list: Array<String>) : Map<String, String> {
        val res = HashMap<String, String>()
        for (i in list) {
            res.put("name", i)
        }
        return res
    }
}