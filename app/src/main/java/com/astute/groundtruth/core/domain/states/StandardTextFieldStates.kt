package com.astute.groundtruth.presentation.util.states

import com.astute.groundtruth.core.util.Error

data class StandardTextFieldState(
    val text: String = "",
    val error: Error? = null
)