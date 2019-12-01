package ru.skillbranch.gameofthrones

import android.os.Bundle

import android.content.Intent
import androidx.fragment.app.Fragment
import com.ncapdevi.fragnav.FragNavController
import ru.skillbranch.gameofthrones.ui.MainFragment


class MainActivity : BaseActivity(),
    FragNavController.TransactionListener,
    FragNavController.RootFragmentListener,
    BaseFragment.FragmentNavigation
    {

    override val layoutRes: Int = R.layout.activity_main

    private val PERMISSIONS_REQUEST = 1
    lateinit var navController: FragNavController
    private val TAB_SIZE = 1
    private val START_INDEX = 0

    private var savedInstanceState: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.savedInstanceState = savedInstanceState
        App.INSTANCE.appComponent.inject(activity = this@MainActivity)
        startApp()
    }

    override fun onFragmentTransaction(fragment: Fragment?, transactionType: FragNavController.TransactionType) {
    }

    override fun onTabTransaction(fragment: Fragment?, index: Int) {
    }

    override val numberOfRootFragments: Int
        get() = TAB_SIZE

    override fun getRootFragment(index: Int): Fragment {
        return MainFragment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        navController.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        /*if(navController.currentFrag is DeleteAccountFragment){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }*/
        if (navController.isRootFragment || !navController.popFragment()) {
            super.onBackPressed()
        }
    }

    override fun popFragment() {
        navController.popFragment()
    }

    override fun replaceFragment(fragment: BaseFragment) {
        navController.replaceFragment(fragment)
    }

    override fun pushFragment(fragment: BaseFragment) {
        navController.pushFragment(fragment)
    }

    override fun isRootFragment(): Boolean {
        return navController.isRootFragment
    }

    override fun clearStack() {
        return navController.clearStack()
    }

    private fun startApp() {
        navController = FragNavController(supportFragmentManager, R.id.mainScreenContainer).also {
            it.transactionListener = this
            it.rootFragmentListener = this
            it.initialize(START_INDEX, savedInstanceState)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        navController.currentFrag?.onActivityResult(requestCode, resultCode, data)
    }
}

