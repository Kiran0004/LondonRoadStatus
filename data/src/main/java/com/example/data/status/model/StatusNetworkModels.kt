package com.example.data.status.model

import com.google.gson.annotations.SerializedName

data class LineStatusModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("displayName")
    val name: String,

    @SerializedName("statusSeverity")
    val severityLevel: String,
    @SerializedName("statusSeverityDescription")
    val severityLevelDescription: String
)

