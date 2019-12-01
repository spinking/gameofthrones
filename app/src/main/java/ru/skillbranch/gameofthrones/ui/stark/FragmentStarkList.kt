package ru.skillbranch.gameofthrones.ui.stark

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recycler_list.*
import ru.skillbranch.gameofthrones.BaseFragment
import ru.skillbranch.gameofthrones.R

class FragmentStarkList: BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_recycler_list

    lateinit var adapter: StarkAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StarkAdapter(mutableListOf()) {

        }

        data_list.layoutManager = LinearLayoutManager(context)

    }
}