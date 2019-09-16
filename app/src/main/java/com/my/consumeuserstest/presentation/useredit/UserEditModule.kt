package com.my.consumeuserstest.presentation.useredit

import com.my.consumeuserstest.di.PerScreen
import com.my.consumeuserstest.domain.repository.UsersRepository
import com.my.consumeuserstest.domain.usecases.UserUpdateUseCase
import dagger.Module
import dagger.Provides

@Module
class UserEditModule {

    @PerScreen
    @Provides
    fun provideAddUserUseCase(userEditRepository: UsersRepository) =
        UserUpdateUseCase(userEditRepository)

    @PerScreen
    @Provides
    fun provideAddUserPresenter(userUpdateUseCase: UserUpdateUseCase) =
        UserEditPresenter(userUpdateUseCase)
}