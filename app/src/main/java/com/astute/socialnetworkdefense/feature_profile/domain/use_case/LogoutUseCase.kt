package com.astute.socialnetworkdefense.feature_profile.domain.use_case

import com.astute.socialnetworkdefense.core.domain.repository.ProfileRepository

class LogoutUseCase(
    private val repository: ProfileRepository
) {

    operator fun invoke() {
        repository.logout()
    }
}