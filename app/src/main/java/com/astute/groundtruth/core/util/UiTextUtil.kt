package com.astute.groundtruth.core.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.astute.groundtruth.core.presentation.util.UiText

@Composable
fun UiText.asString(): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> stringResource(id = this.id)
    }
}

fun UiText.asString(context: Context): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> context.getString(this.id)
    }
}