package com.astute.groundtruth.feature_auth.domain.use_case

import com.astute.groundtruth.core.util.SimpleResource
import com.astute.groundtruth.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): SimpleResource {
        return repository.authenticate()
    }
}