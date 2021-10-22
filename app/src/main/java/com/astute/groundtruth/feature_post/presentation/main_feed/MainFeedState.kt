package com.astute.groundtruth.feature_post.presentation.main_feed

import com.astute.groundtruth.core.domain.models.Post

data class MainFeedState(
    val isLoadingFirstTime: Boolean = true,
    val isLoadingNewPosts: Boolean = false,
)