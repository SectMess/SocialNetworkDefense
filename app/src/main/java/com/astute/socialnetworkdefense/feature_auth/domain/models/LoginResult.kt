package com.astute.socialnetworkdefense.feature_auth.domain.models

import com.astute.socialnetworkdefense.core.util.SimpleResource
import com.astute.socialnetworkdefense.feature_auth.presentation.util.AuthError

data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
