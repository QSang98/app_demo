package com.example.demoapp.data

import com.example.demoapp.model.LogInModel
import com.example.demoapp.model.LogInRequest
import com.example.demoapp.model.UserModel
import com.example.demoapp.model.UserRequest
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @POST("/")
    fun userLogIn(@Body logInRequest: LogInRequest): Single<LogInModel>

    @POST("/")
    fun getUser(@Body userRequest: UserRequest): Single<UserModel>
}
