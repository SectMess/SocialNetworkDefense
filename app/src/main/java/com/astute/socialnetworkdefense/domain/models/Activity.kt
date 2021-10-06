package com.astute.socialnetworkdefense.domain.models

import com.astute.socialnetworkdefense.domain.util.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)