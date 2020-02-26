package com.example.roadstatus.status.viewmodel

import com.example.roadstatus.status.model.RoadStatusPresentation

sealed class StatusState {
    object Error : StatusState()
    object Loading : StatusState()
    data class Data(val linesStatuses: List<RoadStatusPresentation>) : StatusState()
}

