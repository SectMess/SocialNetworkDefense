package com.astute.groundtruth.feature_post.presentation.post_detail

import com.astute.groundtruth.core.domain.models.Comment
import com.astute.groundtruth.core.domain.models.Post

data class PostDetailState(
    val post: Post? = null,
    val comments: List<Comment> = emptyList(),
    val isLoadingPost: Boolean = false,
    val isLoadingComments: Boolean = false
)