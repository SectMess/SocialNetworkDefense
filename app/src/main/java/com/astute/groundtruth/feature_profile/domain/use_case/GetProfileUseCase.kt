package com.astute.groundtruth.feature_profile.domain.use_case

import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.feature_profile.domain.model.Profile
import com.astute.groundtruth.feature_profile.domain.repository.ProfileRepository

class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}