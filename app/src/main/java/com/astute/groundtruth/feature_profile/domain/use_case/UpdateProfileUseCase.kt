package com.astute.groundtruth.feature_profile.domain.use_case

import android.net.Uri
import android.util.Patterns
import com.astute.groundtruth.R
import com.astute.groundtruth.core.presentation.util.UiText
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.core.util.SimpleResource
import com.astute.groundtruth.feature_profile.domain.model.UpdateProfileData
import com.astute.groundtruth.feature_profile.domain.repository.ProfileRepository
import com.astute.groundtruth.feature_profile.domain.util.ProfileConstants

class UpdateProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(
        updateProfileData: UpdateProfileData,
        profilePictureUri: Uri?,
        bannerUri: Uri?,
    ): SimpleResource {
        if(updateProfileData.username.isBlank()) {
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_username_empty)
            )
        }
        val isValidGithubUrl = ProfileConstants.GITHUB_PROFILE_REGEX.matches(updateProfileData.gitHubUrl)
        if (!isValidGithubUrl) {
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_invalid_github_url)
            )
        }

        val isValidInstagramUrl = ProfileConstants.INSTAGRAM_PROFILE_REGEX.matches(updateProfileData.instagramUrl)
        if (!isValidInstagramUrl) {
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_invalid_instagram_url)
            )
        }

        val isValidLinkedUrl = ProfileConstants.LINKED_IN_PROFILE_REGEX.matches(updateProfileData.linkedInUrl)
        if (!isValidLinkedUrl) {
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_invalid_linkedin_url)
            )
        }
        return repository.updateProfile(
            updateProfileData = updateProfileData,
            profilePictureUri = profilePictureUri,
            bannerImageUri = bannerUri
        )
    }
}