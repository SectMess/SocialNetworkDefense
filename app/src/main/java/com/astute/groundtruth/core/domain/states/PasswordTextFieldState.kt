package com.astute.groundtruth.core.domain.states

import com.astute.groundtruth.core.util.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)