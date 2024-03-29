package com.astute.socialnetworkdefense.feature_post.domain.use_case

import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.feature_post.domain.repository.PostRepository

class GetPostDetailsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<Post> {
        return repository.getPostDetails(postId)
    }
}