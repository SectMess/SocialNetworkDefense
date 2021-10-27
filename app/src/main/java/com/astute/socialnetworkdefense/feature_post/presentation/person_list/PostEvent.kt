package com.astute.socialnetworkdefense.feature_post.presentation.person_list

import com.astute.socialnetworkdefense.core.util.Event

sealed class PostEvent : Event() {
    object OnLiked: PostEvent()
}