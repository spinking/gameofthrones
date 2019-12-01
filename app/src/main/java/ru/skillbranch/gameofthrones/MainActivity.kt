package ru.skillbranch.gameofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.Manifest
import android.content.Intent
import androidx.fragment.app.Fragment
import com.ncapdevi.fragnav.FragNavController


class MainActivity : BaseActivity(),
    FragNavController.TransactionListener,
    FragNavController.RootFragmentListener,
    BaseFragment.FragmentNavigation
    {

    override val layoutRes: Int = R.layout.activity_main

    private val PERMISSIONS_REQUEST = 1
    lateinit var navController: FragNavController
    private val TAB_SIZE = 5
    private val START_INDEX = 2

    private var savedInstanceState: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.savedInstanceState = savedInstanceState
        AppConfig.INSTANCE.appComponent.inject(activity = this@MainActivity)
    }

    override fun onFragmentTransaction(fragment: Fragment?, transactionType: FragNavController.TransactionType) {
    }

    override fun onTabTransaction(fragment: Fragment?, index: Int) {
    }

    override val numberOfRootFragments: Int
        get() = TAB_SIZE

    override fun getRootFragment(index: Int): Fragment {
        when (index) {
            /*0 -> return FeedFragment()
            1 -> return SearchFragment()
            2 -> return MapFragment()
            3 -> return ChatFragment()
            4 -> return ProfileFragment()*/
        }
        throw IllegalStateException("Undefined index value")
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

