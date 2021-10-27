package com.astute.socialnetworkdefense.feature_post.presentation.person_list

import com.astute.socialnetworkdefense.core.domain.models.UserItem

data class PersonListState(
    val users: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)