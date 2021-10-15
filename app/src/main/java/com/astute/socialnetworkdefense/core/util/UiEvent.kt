package com.astute.socialnetworkdefense.core.util

sealed class UiEvent {
    data class SnackbarEvent(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
}