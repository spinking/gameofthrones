package ru.skillbranch.gameofthrones.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.fragment_first_list_pager.*
import ru.skillbranch.gameofthrones.App
import ru.skillbranch.gameofthrones.BaseFragment
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.ui.baratheon.FragmentBaratheonList
import ru.skillbranch.gameofthrones.ui.greyjoy.FragmentGreyjoyList
import ru.skillbranch.gameofthrones.ui.lannister.FragmentLannisterList
import ru.skillbranch.gameofthrones.ui.martel.FragmentMartelList
import ru.skillbranch.gameofthrones.ui.stark.FragmentStarkList
import ru.skillbranch.gameofthrones.ui.targaryen.FragmentTargaryenList
import ru.skillbranch.gameofthrones.ui.tyrell.FragmentTyrellList

class MainFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_first_list_pager

    companion object {
        private val titles = arrayOf("Stark", "Lannister", "Targaryen", "Baratheon", "Greyjoy", "Martel", "Tyrell")
    }

    init {
        App.INSTANCE.appComponent.inject(this@MainFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tab_layout.setupWithViewPager(view_pager)

        setHasOptionsMenu(true)

        configureToolbar(data_toolbar)
        (activity as AppCompatActivity).apply {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            data_toolbar.setPadding(0,0,0,0)
            data_toolbar.setContentInsetsAbsolute(0,0)
        }

        view_pager.adapter = FindListPagerAdapter(childFragmentManager, arrayListOf(
            FragmentStarkList(),
            FragmentLannisterList(),
            FragmentTargaryenList(),
            FragmentBaratheonList(),
            FragmentGreyjoyList(),
            FragmentMartelList(),
            FragmentTyrellList()
        ))
    }

    private inner class FindListPagerAdapter(fm: FragmentManager, var fragments: List<BaseFragment>) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): BaseFragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }
}