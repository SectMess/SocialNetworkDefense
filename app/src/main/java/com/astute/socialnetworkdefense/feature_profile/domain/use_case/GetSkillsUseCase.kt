package com.astute.socialnetworkdefense.feature_profile.domain.use_case

import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.feature_profile.domain.model.Skill
import com.astute.socialnetworkdefense.core.domain.repository.ProfileRepository

class GetSkillsUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(): Resource<List<Skill>> {
        return repository.getSkills()
    }
}