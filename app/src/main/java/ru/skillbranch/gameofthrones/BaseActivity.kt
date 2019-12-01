package ru.skillbranch.gameofthrones


import android.os.Bundle
import android.view.WindowManager
import com.arellomobile.mvp.MvpAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
abstract class BaseActivity : MvpAppCompatActivity() {
    abstract val layoutRes: Int

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    protected fun Disposable.connect() {
        compositeDisposable.add(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    fun setTransparentStatusBar(isTransparent: Boolean) {
        if (isTransparent) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

    fun setTransparentNavigationBar(isTransparent: Boolean) {
        if (isTransparent) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }
}