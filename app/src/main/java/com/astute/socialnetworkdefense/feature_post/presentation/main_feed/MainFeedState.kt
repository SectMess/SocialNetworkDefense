package com.astute.socialnetworkdefense.feature_post.presentation.main_feed

import com.astute.socialnetworkdefense.core.domain.models.Post

data class MainFeedState(
    val isLoadingFirstTime: Boolean = true,
    val isLoadingNewPosts: Boolean = false,
)