package com.my.consumeuserstest.presentation.userlist

import com.my.consumeuserstest.di.AppComponent
import com.my.consumeuserstest.di.PerScreen
import dagger.Component

@PerScreen
@Component(
    modules = arrayOf(UserListModule::class),
    dependencies = arrayOf(AppComponent::class)
)
interface UserListComponent {
    fun inject(view: UserListView)
}