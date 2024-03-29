package com.astute.socialnetworkdefense.feature_profile.data.remote

import com.astute.socialnetworkdefense.core.data.dto.response.BasicApiResponse
import com.astute.socialnetworkdefense.core.data.dto.response.UserItemDto
import com.astute.socialnetworkdefense.feature_profile.data.remote.request.FollowUpdateRequest
import com.astute.socialnetworkdefense.feature_profile.data.remote.response.ProfileResponse
import com.astute.socialnetworkdefense.feature_profile.data.remote.response.SkillDto
import okhttp3.MultipartBody
import retrofit2.http.*

interface ProfileApi {

    @GET("/api/user/profile")
    suspend fun getProfile(
        @Query("userId") userId: String
    ): BasicApiResponse<ProfileResponse>

    @Multipart
    @PUT("/api/user/update")
    suspend fun updateProfile(
        @Part bannerImage: MultipartBody.Part?,
        @Part profilePicture: MultipartBody.Part?,
        @Part updateProfileData: MultipartBody.Part
    ): BasicApiResponse<Unit>

    @GET("/api/skills/get")
    suspend fun getSkills(): List<SkillDto>

    @GET("/api/user/search")
    suspend fun searchUser(
        @Query("query") query: String
    ): List<UserItemDto>

    @POST("/api/following/follow")
    suspend fun followUser(
        @Body request: FollowUpdateRequest
    ): BasicApiResponse<Unit>

    @DELETE("/api/following/unfollow")
    suspend fun unfollowUser(
        @Query("userId") userId: String
    ): BasicApiResponse<Unit>

    companion object {
        const val BASE_URL = "http://10.0.2.2:8881/"
    }
}