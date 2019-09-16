package com.my.consumeuserstest

import android.app.Application
import com.my.testproject2.presentation.di.AppComponent
import com.my.testproject2.BuildConfig
import com.my.testproject2.presentation.di.DaggerAppComponent
import timber.log.Timber

class TestApplication :Application(){

    companion object {
        lateinit var component: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}