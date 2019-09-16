package com.my.consumeuserstest.domain.usecases

import com.my.consumeuserstest.domain.model.UserList
import com.my.consumeuserstest.domain.repository.UsersRepository
import io.reactivex.Observable

class UserFetchUseCase(private val repository: UsersRepository) {
    fun fetchUsers():Observable<List<UserList>> = repository.fetchAllUsers()
}