package com.example.data.status.model

import com.example.domain.Mapper
import com.example.domain.status.model.LineStatus

class LineStatusModelToLineStatusMapper : Mapper<LineStatusModel, LineStatus> {

    override fun map(from: LineStatusModel): LineStatus {
        return LineStatus(
            id = from.id,
            name = from.name,
            severityLevel = from.severityLevel,
            severityLevelDescription = from.severityLevelDescription
        )
    }
}
