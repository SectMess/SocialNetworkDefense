package com.astute.groundtruth.feature_activity.domain.repository

import androidx.paging.PagingData
import com.astute.groundtruth.core.domain.models.Activity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {

    val activities: Flow<PagingData<Activity>>
}