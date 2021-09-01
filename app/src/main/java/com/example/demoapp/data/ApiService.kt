package com.example.demoapp.data

import com.example.demoapp.model.LogInModel
import com.example.demoapp.model.UserRequest
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @POST("/")
    fun userLogIn(
        @Body email: String,
        @Body pwd: String,
        @Body application: String,
        @Body application_type: Int,
        @Body application_version: String,
        @Body device_id: String,
        @Body device_name: String,
        @Body device_type: Int,
        @Body os_version: String,
        @Body api: String
    ): Single<LogInModel>
}
