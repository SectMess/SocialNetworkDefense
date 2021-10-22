package com.astute.groundtruth.feature_profile.presentation.edit_profile

import com.astute.groundtruth.feature_profile.domain.model.Skill

data class SkillsState(
    val skills: List<Skill> = emptyList(),
    val selectedSkills: List<Skill> = emptyList()
)