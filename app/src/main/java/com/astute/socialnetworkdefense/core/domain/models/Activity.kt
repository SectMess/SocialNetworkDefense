package com.astute.socialnetworkdefense.core.domain.models

import com.astute.socialnetworkdefense.feature_activity.domain.ActivityType

data class Activity(
    val userId: String,
    val parentId: String,
    val username: String,
    val activityType: ActivityType,
    val formattedTime: String,
)