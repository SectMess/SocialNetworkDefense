package com.astute.socialnetworkdefense.core.domain.states

import com.astute.socialnetworkdefense.core.util.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)