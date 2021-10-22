package com.astute.groundtruth.feature_post.domain.use_case

import com.astute.groundtruth.core.domain.models.Comment
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.feature_post.domain.repository.PostRepository

class GetCommentsForPostUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<List<Comment>> {
        return repository.getCommentsForPost(postId)
    }
}