package com.my.testproject2.domain.usecases

import com.my.testproject2.domain.model.User
import com.my.testproject2.domain.model.UserAdd
import com.my.testproject2.domain.repository.UsersRepository
import io.reactivex.Completable

class UserUpdateUseCase(private val repository: UsersRepository) {
    fun updateUser(user: User):Completable = repository.updateUser(user)
}