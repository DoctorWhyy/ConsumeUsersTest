package com.my.consumeuserstest.domain.repository

import com.my.consumeuserstest.domain.model.User
import com.my.consumeuserstest.domain.model.UserList
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersRepository {

    @POST("/users/1.json")
    fun updateUser(@Body user: User):Completable

    @POST("/users.json")
    fun addNewUser(@Body user: User):Completable

    @GET("/users.json")
    fun fetchAllUsers(): Observable<List<UserList>>
}