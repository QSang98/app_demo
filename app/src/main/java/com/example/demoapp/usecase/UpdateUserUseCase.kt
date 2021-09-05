package com.example.demoapp.usecase

import com.example.demoapp.model.UpdateModel
import com.example.demoapp.repository.ProfileRepository
import io.reactivex.Single
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateUserUseCase @Inject constructor(
    val profileRepository: ProfileRepository
) {
    operator fun invoke(
        api: String,
        token: String,
        sum: String,
        size: Long,
        time: Long,
        requestBody: RequestBody
    ): Single<UpdateModel> {
        return profileRepository.updateUser(
            api, token, sum, size, time, requestBody
        )
    }
}