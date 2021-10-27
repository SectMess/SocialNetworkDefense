package com.astute.socialnetworkdefense.feature_post.domain.use_case

import com.astute.socialnetworkdefense.core.domain.models.UserItem
import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.feature_post.domain.repository.PostRepository

class GetLikesForParentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(parentId: String): Resource<List<UserItem>> {
        return repository.getLikesForParent(parentId)
    }
}