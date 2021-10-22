package com.astute.groundtruth.feature_post.presentation.util

import com.astute.groundtruth.core.util.Error

sealed class PostDescriptionError : Error() {
    object FieldEmpty: PostDescriptionError()
}