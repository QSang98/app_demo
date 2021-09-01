package com.example.demoapp.data

import com.example.demoapp.model.LogInModel
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @POST("/")
    fun userLogIn(@Body logInModel: LogInModel): Single<LogInModel>
}
