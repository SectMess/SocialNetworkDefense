package com.astute.socialnetworkdefense.feature_profile.domain.use_case

import com.astute.socialnetworkdefense.core.domain.models.UserItem
import com.astute.socialnetworkdefense.core.domain.repository.ProfileRepository
import com.astute.socialnetworkdefense.core.util.Resource

class SearchUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(query: String): Resource<List<UserItem>> {
        if(query.isBlank()) {
            return Resource.Success(data = emptyList())
        }
        return repository.searchUser(query)
    }
}