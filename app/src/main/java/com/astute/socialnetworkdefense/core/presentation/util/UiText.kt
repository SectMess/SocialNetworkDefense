package com.astute.socialnetworkdefense.core.presentation.util

import androidx.annotation.StringRes
import com.astute.socialnetworkdefense.R

sealed class UiText {
    data class DynamicString(val value: String): UiText()
    data class StringResource(@StringRes val id: Int): UiText()

    companion object {
        fun unknownError(): UiText {
            return StringResource(R.string.error_unknown)
        }
    }
}
