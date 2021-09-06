package com.example.demoapp.data

import com.example.demoapp.model.*
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiService {

    @POST("/")
    fun userLogIn(@Body logInRequest: LogInRequest): Single<LogInModel>

    @POST("/")
    fun getUser(@Body userRequest: UserRequest): Single<UserModel>
}
