package com.astute.socialnetworkdefense.feature_auth.presentation.util

import com.astute.socialnetworkdefense.core.util.Error

sealed class AuthError : Error() {
    object FieldEmpty : AuthError()
    object InputTooShort : AuthError()
    object InvalidEmail: AuthError()
    object InvalidPassword : AuthError()
}