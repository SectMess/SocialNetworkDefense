package com.astute.socialnetworkdefense.core.domain.models

import com.astute.socialnetworkdefense.feature_activity.domain.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)