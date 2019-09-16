package com.my.consumeuserstest.presentation.mvp

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity


abstract class BaseView : AppCompatActivity() {

    // Inject dependencies once per life of Controller
    val inject by lazy { injectDependencies() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        inject
        init(savedInstanceState)
    }

    abstract fun init(savedInstanceState: Bundle?)

    override fun onDestroy() {
        //getPresenter().destroy()
        super.onDestroy()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun injectDependencies()
    //protected abstract fun getPresenter(): MvpPresenter
    abstract fun stopScreen()

    override fun onStop() {
        super.onStop()
        stopScreen()
    }
}