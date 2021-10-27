package com.astute.socialnetworkdefense.core.domain.use_case

import com.astute.socialnetworkdefense.core.domain.repository.ProfileRepository
import com.astute.socialnetworkdefense.core.util.SimpleResource

class ToggleFollowStateForUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String, isFollowing: Boolean): SimpleResource {
        return if(isFollowing) {
            repository.unfollowUser(userId)
        } else {
            repository.followUser(userId)
        }
    }
}