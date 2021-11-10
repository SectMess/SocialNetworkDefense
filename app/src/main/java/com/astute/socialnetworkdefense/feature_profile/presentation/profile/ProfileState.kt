package com.astute.socialnetworkdefense.feature_profile.presentation.profile

import com.astute.socialnetworkdefense.feature_profile.domain.model.Profile

data class ProfileState(
    val profile: Profile? = null,
    val isLoading: Boolean = false,
    val isLogoutDialogVisible: Boolean = false

)