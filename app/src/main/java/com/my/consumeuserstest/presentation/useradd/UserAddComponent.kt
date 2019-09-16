package com.my.consumeuserstest.presentation.useradd

import com.my.consumeuserstest.di.AppComponent
import com.my.consumeuserstest.di.PerScreen
import dagger.Component

@PerScreen
@Component(
    modules = arrayOf(UserAddModule::class),
    dependencies = arrayOf(AppComponent::class)
)
interface UserAddComponent {
    fun inject(view: UserAddView)
}