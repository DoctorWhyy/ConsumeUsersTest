package com.my.consumeuserstest.domain.usecases

import com.my.consumeuserstest.domain.model.User
import com.my.consumeuserstest.domain.repository.UsersRepository
import io.reactivex.Completable

class UserUpdateUseCase(private val repository: UsersRepository) {
    fun updateUser(user: User):Completable = repository.updateUser(user)
}