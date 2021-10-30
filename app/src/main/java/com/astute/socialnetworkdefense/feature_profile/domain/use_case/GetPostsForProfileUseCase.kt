package com.astute.socialnetworkdefense.feature_profile.domain.use_case

import androidx.paging.PagingData
import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.core.domain.repository.ProfileRepository
import com.astute.socialnetworkdefense.core.util.Resource
import kotlinx.coroutines.flow.Flow

class GetPostsForProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String, page: Int): Resource<List<Post>> {
        return repository.getPostsPaged(
            userId = userId,
            page = page
        )
    }
}