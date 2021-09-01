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

    operator fun invoke(logInModel: LogInModel): Single<LogInModel> {
        return profileRepository.userLogIn(logInModel)
    }
}
