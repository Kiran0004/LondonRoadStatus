package com.example.roadstatus.status.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.domain.status.GetRoadStatusInteractor
import com.example.domain.status.model.StatusResult
import com.example.roadstatus.status.model.RoadStatusPresentationMapper
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class StatusViewModel constructor(
        private val getRoadStatusInteractor: GetRoadStatusInteractor,
        private val mapper: RoadStatusPresentationMapper
) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var linesStatusLiveData: MutableLiveData<StatusState> = MutableLiveData()

    fun fetchLinesStatus(roadId:String) {
        linesStatusLiveData.postValue(StatusState.Loading)
        launch {
            val statusResult = withContext(Dispatchers.IO) { getRoadStatusInteractor.execute(roadId) }
            when (statusResult) {
                is StatusResult.Success -> {
                    val linesStatus = statusResult.linesStatus.map {
                        mapper.map(it)
                    }
                    linesStatusLiveData.postValue(StatusState.Data(linesStatus))
                }
                StatusResult.Error -> linesStatusLiveData.postValue(StatusState.Error)
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
