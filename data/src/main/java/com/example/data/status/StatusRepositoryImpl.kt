package com.example.data.status

import com.example.data.status.model.LineStatusModelToLineStatusMapper
import com.example.domain.status.StatusRepository
import com.example.domain.status.model.StatusResult

class StatusRepositoryImpl constructor(
    private val statusService: StatusService,
    private val mapper: LineStatusModelToLineStatusMapper
) : StatusRepository {
    suspend override  fun getLinesStatus(roadId:String): StatusResult =
        try {
            val linesStatus = statusService.getRoadStatus(roadId).await()
                .map { mapper.map(it) }
            StatusResult.Success(linesStatus)
        } catch (throwable: Throwable) {
            StatusResult.Error
        }
}
