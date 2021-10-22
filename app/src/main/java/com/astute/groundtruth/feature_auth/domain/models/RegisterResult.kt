package com.astute.groundtruth.feature_auth.domain.models

import com.astute.groundtruth.core.util.SimpleResource
import com.astute.groundtruth.feature_auth.presentation.util.AuthError

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)