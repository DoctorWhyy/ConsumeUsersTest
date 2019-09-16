package com.my.consumeuserstest.presentation.userlist

import com.my.consumeuserstest.di.PerScreen
import com.my.consumeuserstest.domain.repository.UsersRepository
import com.my.consumeuserstest.domain.usecases.UserFetchUseCase
import dagger.Module
import dagger.Provides

@Module
class UserListModule {

    @PerScreen
    @Provides
    fun provideUserListUseCase(userListRepository: UsersRepository) =
        UserFetchUseCase(userListRepository)

    @PerScreen
    @Provides
    fun provideUserListPresenter(userFetchUseCase: UserFetchUseCase) =
        UserListPresenter(userFetchUseCase)
}