package com.astute.groundtruth.feature_post.domain.use_case

import androidx.paging.PagingData
import com.astute.groundtruth.core.domain.models.Post
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.feature_post.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {

    operator fun invoke(): Flow<PagingData<Post>> {
        return repository.posts
    }

}