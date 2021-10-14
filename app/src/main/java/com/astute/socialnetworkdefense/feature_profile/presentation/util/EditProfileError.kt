package com.astute.socialnetworkdefense.feature_profile.presentation.util

import com.astute.socialnetworkdefense.core.util.Error

sealed class EditProfileError : Error() {
    object FieldEmpty: EditProfileError()
}