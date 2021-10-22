package com.astute.groundtruth.feature_map.data.repository

import com.astute.groundtruth.core.domain.models.Mission
import com.astute.groundtruth.core.util.Resource


interface MissionsRepository {

    suspend fun getMission(missionId: String): Resource<Mission>

}