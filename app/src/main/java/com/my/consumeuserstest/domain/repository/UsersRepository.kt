package com.my.testproject2.domain.repository

import com.my.testproject2.domain.model.User
import com.my.testproject2.domain.model.UserAdd
import com.my.testproject2.domain.model.UserList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface UsersRepository {

    @POST("/users/1.json")
    fun updateUser(@Body user: User):Completable

    @POST("/users.json")
    fun addNewUser(@Body user: User):Completable

    @GET("/users.json")
    fun fetchAllUsers(): Observable<List<UserList>>
}