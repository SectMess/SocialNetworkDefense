package com.astute.socialnetworkdefense.feature_auth.data.data.remote.request

data class CreateAccountRequest(
    val email: String,
    val username: String,
    val password: String
)