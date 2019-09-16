package com.my.testproject2.domain.usecases

import com.my.testproject2.domain.model.UserList
import com.my.testproject2.domain.repository.UsersRepository
import io.reactivex.Observable

class UserFetchUseCase(private val repository: UsersRepository) {
    fun fetchUsers():Observable<List<UserList>> = repository.fetchAllUsers()
}