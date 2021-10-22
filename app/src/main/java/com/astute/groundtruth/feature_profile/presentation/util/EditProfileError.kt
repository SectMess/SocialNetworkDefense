package com.astute.groundtruth.feature_profile.presentation.util

import com.astute.groundtruth.core.util.Error

sealed class EditProfileError : Error() {
    object FieldEmpty: EditProfileError()
}