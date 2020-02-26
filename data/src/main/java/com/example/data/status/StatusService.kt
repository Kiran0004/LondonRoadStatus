package com.example.data.status

import com.example.data.status.model.LineStatusModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface StatusService {

    @GET("Road/{roadId}")
    fun getRoadStatus(@Path("roadId") eventId: String): Deferred<List<LineStatusModel>>

}
