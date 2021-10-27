package com.astute.socialnetworkdefense.core.presentation.util

import com.astute.socialnetworkdefense.core.util.Event

sealed class UiEvent: Event() {
    data class ShowSnackbar(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
}