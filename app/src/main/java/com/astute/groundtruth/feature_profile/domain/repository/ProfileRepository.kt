package com.astute.groundtruth.feature_profile.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.astute.groundtruth.core.domain.models.Post
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.core.util.SimpleResource
import com.astute.groundtruth.feature_profile.domain.model.Profile
import com.astute.groundtruth.feature_profile.domain.model.Skill
import com.astute.groundtruth.feature_profile.domain.model.UpdateProfileData
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
}