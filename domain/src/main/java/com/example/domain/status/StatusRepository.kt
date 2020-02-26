package com.example.domain.status


import com.example.domain.status.model.StatusResult

interface StatusRepository {

    suspend fun getLinesStatus(roadId:String): StatusResult

}
