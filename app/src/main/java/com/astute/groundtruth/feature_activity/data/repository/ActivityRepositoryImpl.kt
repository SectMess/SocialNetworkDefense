package com.astute.groundtruth.feature_activity.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.astute.groundtruth.core.domain.models.Activity
import com.astute.groundtruth.core.util.Constants
import com.astute.groundtruth.feature_activity.data.paging.ActivitySource
import com.astute.groundtruth.feature_activity.data.remote.ActivityApi
import com.astute.groundtruth.feature_activity.domain.repository.ActivityRepository
import kotlinx.coroutines.flow.Flow

class ActivityRepositoryImpl(
    private val api: ActivityApi
): ActivityRepository {

    override val activities: Flow<PagingData<Activity>>
        get() = Pager(PagingConfig(pageSize = Constants.DEFAULT_PAGE_SIZE)) {
            ActivitySource(api)
        }.flow
}