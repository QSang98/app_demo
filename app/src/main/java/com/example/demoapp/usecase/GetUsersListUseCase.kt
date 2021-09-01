package com.example.demoapp.usecase

import com.example.demoapp.repository.ProfileRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUsersListUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
)
