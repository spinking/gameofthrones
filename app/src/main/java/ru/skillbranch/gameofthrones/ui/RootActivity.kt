package ru.skillbranch.gameofthrones.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import ru.skillbranch.gameofthrones.R

class RootActivity : AppCompatActivity() {


    private lateinit var viewModel: RootViewModel
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
        initViewModel()
        savedInstanceState ?: prepareData()
        navController = Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
    }

    private fun prepareData() {
        viewModel.syncDataIfNeed().observe(this, Observer<LoadResult<Boolean>> {
            when(it) {
                is LoadResult.Loading -> {
                    navController.navigate(R.id.nav_splash)
                }
                is LoadResult.Success -> {
                    val action = SplashFragmentDirections.actionNavSplashToNavHouses()
                    navController.navigate(action)
                }
                is LoadResult.Error -> {
                    Snackbar.make(
                        root_container,
                        it.errorMessage.toString(),
                        Snackbar.LENGTH_INDEFINITE
                    ).show()
                }
            }
        })
    }

    private fun initViewModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}