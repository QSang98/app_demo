package com.example.demoapp.usecase

import com.example.demoapp.model.LogInModel
import com.example.demoapp.repository.ProfileRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLogInUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    operator fun invoke(
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
        return profileRepository.userLogIn(
           email, pwd, application, application_type, application_version, device_id, device_name, device_type, os_version, api
        )
    }
}
