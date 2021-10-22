package com.astute.groundtruth.feature_map.presentation.mission_map

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.astute.groundtruth.core.data.dto.response.BasicApiResponse
import com.astute.groundtruth.core.domain.models.Mission
import com.astute.groundtruth.core.presentation.util.UiEvent
import com.astute.groundtruth.core.presentation.util.UiText
import com.astute.groundtruth.core.util.Resource
import com.astute.groundtruth.feature_map.data.repository.MissionsRepository
import com.astute.groundtruth.feature_map.domain.use_case.GetMissionUseCase
import com.astute.groundtruth.feature_post.presentation.main_feed.MainFeedEvent
import com.astute.groundtruth.feature_post.presentation.post_detail.PostDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MissionMapViewModel @Inject constructor(
    private val getMissionUseCase: GetMissionUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MissionMapState())
    val state: State<MissionMapState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {

        loadMissionMap(missionId = "1")

    }


    fun onEvent(event: MissionMapEvent) {
        when (event) {
            is MissionMapEvent.LoadAllMissions -> {

            }
            is MissionMapEvent.LoadedPage -> {

            }
        }
    }

    private fun loadMissionMap(missionId: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoadingMap = true
            )
            val result = getMissionUseCase(missionId)
            println("Result $result")
            when (result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        mission = result.data,
                        isLoadingMap = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoadingMap = false
                    )
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(
                            result.uiText ?: UiText.unknownError()
                        )
                    )
                }
            }
        }
    }

}