package com.example.demoapp.repository

import com.example.demoapp.data.ApiService
import com.example.demoapp.model.LogInModel
import com.example.demoapp.model.LogInRequest
import com.example.demoapp.model.UserModel
import com.example.demoapp.model.UserRequest
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun userLogIn(
        email: String,
        pwd: String,
        application: String,
        application_type: Int,
        application_version: String,
        device_id: String,
        device_name: String,
        device_type: Int,
        os_version: String,
        api: String
    ): Single<LogInModel> {
        return apiService.userLogIn(
            LogInRequest(email, pwd, application, application_type, application_version, device_id, device_name, device_type, os_version, api)
        )
    }

    fun getUser(api: String): Single<UserModel> {
        return apiService.getUser(UserRequest(api))
    }
}
