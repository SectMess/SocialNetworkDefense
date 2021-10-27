package com.astute.socialnetworkdefense.feature_profile.presentation.search

import com.astute.socialnetworkdefense.core.presentation.util.UiText
import com.astute.socialnetworkdefense.core.util.Error

data class SearchError(
    val message: UiText
): Error()