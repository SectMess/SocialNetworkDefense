package com.astute.groundtruth.feature_map.data.local

import com.astute.groundtruth.core.domain.models.Mission
import com.astute.groundtruth.core.domain.models.MissionType
import javax.inject.Inject
import javax.inject.Singleton


//TODO: Adjust the mission parameters

@Singleton
class MissionLocalDataSource @Inject constructor() {

    val missionList = listOf(
        Mission(
            missionId = "1",
            latitude = "40.416775",
            longitude = "-3.703790",
            description = "Mission 1",
            rewards = "$10",
            missionType = MissionType.MysteryShopping,
            formattedTime = "1234"
        ),
        Mission(
            missionId = "1",
            latitude = "40.416775",
            longitude = "-3.703790",
            description = "Mission 1",
            rewards = "$10",
            missionType = MissionType.MysteryShopping,
            formattedTime = "1234"
        ),
        Mission(
            missionId = "1",
            latitude = "40.416775",
            longitude = "-3.703790",
            description = "Mission 1",
            rewards = "$10",
            missionType = MissionType.MysteryShopping,
            formattedTime = "1234"
        ),
        )
}