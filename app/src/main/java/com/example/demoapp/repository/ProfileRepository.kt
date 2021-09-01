package com.example.demoapp.repository

import com.example.demoapp.data.ApiService
import com.example.demoapp.model.LogInModel
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun userLogIn(logInModel: LogInModel): Single<LogInModel> {
        return apiService.userLogIn(logInModel)
    }
}