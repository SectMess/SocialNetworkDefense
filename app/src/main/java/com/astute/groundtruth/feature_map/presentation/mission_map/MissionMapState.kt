package com.astute.groundtruth.feature_map.presentation.mission_map

import com.astute.groundtruth.core.domain.models.Mission

data class MissionMapState(
    val mission: Mission? = null,
    val isLoadingMap: Boolean = true,
)