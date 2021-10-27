package com.astute.socialnetworkdefense.core.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.core.domain.models.UserItem
import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.core.util.SimpleResource
import com.astute.socialnetworkdefense.feature_profile.domain.model.Profile
import com.astute.socialnetworkdefense.feature_profile.domain.model.Skill
import com.astute.socialnetworkdefense.feature_profile.domain.model.UpdateProfileData
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getPostsPaged(userId: String): Flow<PagingData<Post>>

    suspend fun getProfile(userId: String): Resource<Profile>

    suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?
    ): SimpleResource

    suspend fun getSkills(): Resource<List<Skill>>

    suspend fun searchUser(query: String): Resource<List<UserItem>>

    suspend fun followUser(userId: String): SimpleResource

    suspend fun unfollowUser(userId: String): SimpleResource
}