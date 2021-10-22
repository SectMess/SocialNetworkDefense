package com.astute.groundtruth.core.domain.models

import com.astute.groundtruth.feature_activity.domain.ActivityType

data class Activity(
    val userId: String,
    val parentId: String,
    val username: String,
    val activityType: ActivityType,
    val formattedTime: String,
)