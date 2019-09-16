package com.my.testproject2.domain.usecases

import com.my.testproject2.domain.model.User
import com.my.testproject2.domain.model.UserAdd
import com.my.testproject2.domain.repository.UsersRepository
import io.reactivex.Completable

class UserAddUseCase (private val repository: UsersRepository){
    fun addUser(user: User):Completable = repository.addNewUser(user)
}