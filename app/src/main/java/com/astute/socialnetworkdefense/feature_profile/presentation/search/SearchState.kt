package com.astute.socialnetworkdefense.feature_profile.presentation.search

import com.astute.socialnetworkdefense.core.domain.models.UserItem

data class SearchState(
    val userItems: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)