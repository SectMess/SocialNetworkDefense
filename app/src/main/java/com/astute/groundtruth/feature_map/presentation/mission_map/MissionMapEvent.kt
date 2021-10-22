package com.astute.groundtruth.feature_map.presentation.mission_map

import com.astute.groundtruth.feature_post.presentation.main_feed.MainFeedEvent

sealed class MissionMapEvent {

    object LoadAllMissions: MissionMapEvent()
    object LoadedPage: MissionMapEvent()
}