package com.astute.groundtruth.feature_post.domain.use_case

import com.astute.groundtruth.core.domain.models.Post
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.feature_post.domain.repository.PostRepository

class GetPostDetailsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<Post> {
        return repository.getPostDetails(postId)
    }
}