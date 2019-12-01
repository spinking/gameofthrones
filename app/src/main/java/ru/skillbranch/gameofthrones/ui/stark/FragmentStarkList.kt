package ru.skillbranch.gameofthrones.ui.stark

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_recycler_list.*
import ru.skillbranch.gameofthrones.App
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.BaseFragment
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import ru.skillbranch.gameofthrones.presentations.stark.IStarkView
import ru.skillbranch.gameofthrones.presentations.stark.StarkPresenter
import javax.inject.Inject

class FragmentStarkList: BaseFragment(), IStarkView {
    override val layoutRes: Int
        get() = R.layout.fragment_recycler_list

    lateinit var adapter: StarkAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: StarkPresenter

    @ProvidePresenter
    fun providePresenter() : StarkPresenter = presenter

    init {
        App.INSTANCE.appComponent.inject(this@FragmentStarkList)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StarkAdapter(mutableListOf()) {

        }

        data_list.layoutManager= LinearLayoutManager(context)

        presenter.updateHouses(AppConfig.NEED_HOUSES.toList())

    }

    override fun showHouses(houses: List<HouseRes>) {
        adapter.setHouses(houses)
    }
}