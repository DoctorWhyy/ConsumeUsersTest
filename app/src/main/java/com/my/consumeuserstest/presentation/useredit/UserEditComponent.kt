package com.my.consumeuserstest.presentation.useredit


import com.my.consumeuserstest.di.AppComponent
import com.my.consumeuserstest.di.PerScreen
import dagger.Component

@PerScreen
@Component(
    modules = arrayOf(UserEditModule::class),
    dependencies = arrayOf(AppComponent::class)
)
interface UserEditComponent {
    fun inject(view: UserEditView)
}