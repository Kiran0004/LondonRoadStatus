package com.example.domain.status

import com.example.domain.status.model.StatusResult

open class GetRoadStatusInteractor constructor(
    private val statusRepository: StatusRepository
) {
     suspend fun execute(roadId:String): StatusResult {
        return statusRepository.getLinesStatus(roadId)
    }
}















