package com.astute.socialnetworkdefense.core.util

interface Paginator<T> {

    suspend fun loadNextItems()
}