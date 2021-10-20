package com.astute.socialnetworkdefense.feature_activity.domain.repository

import androidx.paging.PagingData
import com.astute.socialnetworkdefense.core.domain.models.Activity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {

    val activities: Flow<PagingData<Activity>>
}