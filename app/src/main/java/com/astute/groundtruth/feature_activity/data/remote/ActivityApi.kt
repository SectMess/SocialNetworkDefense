package com.astute.groundtruth.feature_activity.data.remote

import com.astute.groundtruth.core.util.Constants
import com.astute.groundtruth.feature_activity.data.remote.dto.ActivityDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ActivityApi {

    @GET("/api/activity/get")
    suspend fun getActivities(
        @Query("page") page: Int = 0,
        @Query("pageSize") pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): List<ActivityDto>

    companion object {
        const val BASE_URL = "http://10.0.2.2:8881/"
    }
}