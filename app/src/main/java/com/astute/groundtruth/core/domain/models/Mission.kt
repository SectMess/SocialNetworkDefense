package com.astute.groundtruth.core.domain.models

import com.astute.groundtruth.feature_activity.domain.ActivityType

data class Mission(
    val missionId: String,
    val latitude: String,
    val longitude: String,
    val description: String,
    val rewards: String,
    val missionType: MissionType,
    val formattedTime: String,
)

sealed class MissionType(val type: Int) {
    object PhotoTaking : MissionType(0)
    object RouteWalking : MissionType(1)
    object MysteryShopping : MissionType(2)
    object WifiHunting : MissionType(3)
}
