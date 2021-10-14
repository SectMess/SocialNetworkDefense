package com.astute.socialnetworkdefense.presentation.util.states

import com.astute.socialnetworkdefense.core.util.Error

data class StandardTextFieldState(
    val text: String = "",
    val error: Error? = null
)