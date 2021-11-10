package com.astute.socialnetworkdefense.feature_post.domain.use_case

import androidx.paging.PagingData
import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.core.util.Constants
import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.feature_post.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        page: Int,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): Resource<List<Post>> {
        return repository.getPostsForFollows(page, pageSize)
    }

}