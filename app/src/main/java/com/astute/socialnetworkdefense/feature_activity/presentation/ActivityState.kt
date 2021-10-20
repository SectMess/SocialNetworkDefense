package com.astute.socialnetworkdefense.feature_activity.presentation

import com.astute.socialnetworkdefense.core.domain.models.Activity

data class ActivityState(
    val activities: List<Activity> = emptyList(),
    val isLoading: Boolean = false,
)