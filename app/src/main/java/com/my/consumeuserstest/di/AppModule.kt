package com.my.consumeuserstest.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = arrayOf(AppDbModule::class))
class AppModule {

    @Singleton
    @Provides
    @Named("applicationContext")
    fun provideContext(application: Application): Context = application.applicationContext
}