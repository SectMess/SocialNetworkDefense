package com.astute.socialnetworkdefense.feature_auth.domain.repository

import com.astute.socialnetworkdefense.core.util.SimpleResource

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource
}