package com.astute.socialnetworkdefense.feature_post.presentation.util

import com.astute.socialnetworkdefense.core.util.Error

sealed class CommentError : Error() {
    object FieldEmpty: CommentError()
}