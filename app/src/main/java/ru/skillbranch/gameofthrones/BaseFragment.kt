package ru.skillbranch.gameofthrones

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseFragment : MvpAppCompatFragment() {
    abstract val layoutRes: Int

    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(layoutRes, container, false)

    open fun onBackPressed() {}

    lateinit var fragmentNavigation: FragmentNavigation

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigation) {
            fragmentNavigation = context
        }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    protected fun Disposable.disposeView() {
        compositeDisposable.add(this)
    }


    fun configureToolbar(toolbar: Toolbar) {
        (context as MvpAppCompatActivity).setSupportActionBar(toolbar)
        (context as MvpAppCompatActivity).supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayShowTitleEnabled(true)
        }
        toolbar.setNavigationOnClickListener {
            (context as MvpAppCompatActivity).onBackPressed()
        }
    }

    interface FragmentNavigation {
        fun pushFragment(fragment: BaseFragment)
        fun replaceFragment(fragment: BaseFragment)
        fun popFragment()
        fun isRootFragment(): Boolean
        fun clearStack()
    }
}