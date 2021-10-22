package com.astute.groundtruth.feature_activity.presentation

import com.astute.groundtruth.core.domain.models.Activity

data class ActivityState(
    val activities: List<Activity> = emptyList(),
    val isLoading: Boolean = false,
)