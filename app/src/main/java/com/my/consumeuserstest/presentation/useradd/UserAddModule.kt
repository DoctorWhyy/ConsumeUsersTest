package com.my.consumeuserstest.presentation.useradd

import com.my.consumeuserstest.di.PerScreen
import com.my.consumeuserstest.domain.repository.UsersRepository
import com.my.consumeuserstest.domain.usecases.UserAddUseCase
import dagger.Module
import dagger.Provides

@Module
class UserAddModule {

    @PerScreen
    @Provides
    fun provideAddUserUseCase(userAddRepository: UsersRepository) =
        UserAddUseCase(userAddRepository)

    @PerScreen
    @Provides
    fun provideAddUserPresenter(userAddUseCase: UserAddUseCase) = UserAddPresenter(userAddUseCase)
}