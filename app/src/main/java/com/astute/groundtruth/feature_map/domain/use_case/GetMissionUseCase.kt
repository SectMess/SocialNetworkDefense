package com.astute.groundtruth.feature_map.domain.use_case

import com.astute.groundtruth.core.domain.models.Mission
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.feature_map.data.repository.MissionsRepository

class GetMissionUseCase(
    private val repository: MissionsRepository
) {

    suspend operator fun invoke(missionId: String): Resource<Mission> {
        return repository.getMission(missionId)
    }
}