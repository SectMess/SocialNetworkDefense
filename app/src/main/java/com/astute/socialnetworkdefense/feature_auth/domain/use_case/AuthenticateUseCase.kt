package com.astute.socialnetworkdefense.feature_auth.domain.use_case

import com.astute.socialnetworkdefense.core.util.SimpleResource
import com.astute.socialnetworkdefense.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): SimpleResource {
        return repository.authenticate()
    }
}