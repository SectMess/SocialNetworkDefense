package com.astute.groundtruth.feature_profile.presentation.profile

import com.astute.groundtruth.feature_profile.domain.model.Profile

data class ProfileState(
    val profile: Profile? = null,
    val isLoading: Boolean = false
)