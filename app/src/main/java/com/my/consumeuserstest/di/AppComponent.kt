package com.my.testproject2.presentation.di

import android.app.Application
import com.my.testproject2.domain.repository.UsersRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class,AppNetworkModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun exposeUsersRepository(): UsersRepository
}