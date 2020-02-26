package com.example.data.status

import com.example.data.status.model.LineStatusModel
import com.example.domain.status.model.LineStatus

fun getLineStatusModel(): LineStatusModel {
    return LineStatusModel(
        id = "id",
        name = "name",
            severityLevel = "minor",
            severityLevelDescription = "severity_level_description"
    )
}

fun getExpectedLineStatus(): LineStatus {
    return LineStatus(
        id = "id",
        name = "name",
        severityLevel = "minor",
        severityLevelDescription = "severity_level_description"
    )
}
