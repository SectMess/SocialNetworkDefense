package com.astute.groundtruth.feature_map.data.repository

import com.astute.groundtruth.R
import com.astute.groundtruth.core.domain.models.Mission
import com.astute.groundtruth.core.presentation.util.UiText
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.feature_map.data.local.MissionLocalDataSource
import retrofit2.HttpException
import java.io.IOException

class MissionsRepositoryImpl(
    private val missionLocalDataSource: MissionLocalDataSource
): MissionsRepository {

    override suspend fun getMission(missionId: String): Resource<Mission> {
        return try {
            val mission = missionLocalDataSource.missionList.find { missionId == missionId }
            Resource.Success(mission)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

}