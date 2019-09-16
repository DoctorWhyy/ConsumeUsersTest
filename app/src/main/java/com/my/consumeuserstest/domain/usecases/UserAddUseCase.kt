package com.my.consumeuserstest.domain.usecases

import com.my.consumeuserstest.domain.model.User
import com.my.consumeuserstest.domain.repository.UsersRepository
import io.reactivex.Completable

class UserAddUseCase (private val repository: UsersRepository){
    fun addUser(user: User):Completable = repository.addNewUser(user)
}