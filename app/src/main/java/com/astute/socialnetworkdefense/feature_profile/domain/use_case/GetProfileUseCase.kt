package com.astute.socialnetworkdefense.feature_profile.domain.use_case

import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.feature_profile.domain.model.Profile
import com.astute.socialnetworkdefense.core.domain.repository.ProfileRepository

class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}