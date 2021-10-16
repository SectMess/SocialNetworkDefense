package com.astute.socialnetworkdefense.feature_profile.domain.repository

import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.feature_profile.domain.model.Profile

interface ProfileRepository {

    suspend fun getProfile(userId: String): Resource<Profile>
}