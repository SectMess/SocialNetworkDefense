package com.astute.groundtruth.di

import com.astute.groundtruth.feature_map.data.local.MissionLocalDataSource
import com.astute.groundtruth.feature_map.data.repository.MissionsRepository
import com.astute.groundtruth.feature_map.data.repository.MissionsRepositoryImpl
import com.astute.groundtruth.feature_map.domain.use_case.GetMissionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MissionModule {

    @Provides
    @Singleton
    fun provideMissionsRepository(missionLocalDataSource: MissionLocalDataSource): MissionsRepository {
        return MissionsRepositoryImpl(missionLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMissionUseCase(repository: MissionsRepository): GetMissionUseCase {
        return GetMissionUseCase(repository)
    }

}
