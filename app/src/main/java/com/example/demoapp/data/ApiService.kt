package com.example.demoapp.data

import com.example.demoapp.model.LogInModel
import com.example.demoapp.model.UserRequest
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @POST("/")
    fun userLogIn(
        @Body userRequest: UserRequest
    ): Single<LogInModel>
}
