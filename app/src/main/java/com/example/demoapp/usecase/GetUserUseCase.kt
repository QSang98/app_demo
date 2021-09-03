package com.example.demoapp.usecase

import com.example.demoapp.model.UserModel
import com.example.demoapp.repository.ProfileRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUserUseCase @Inject constructor(
    val profileRepository: ProfileRepository
) {
    operator fun invoke(api: String): Single<UserModel> {
        return profileRepository.getUser(api)
    }
}