package com.example.roadstatus.status.model

import com.example.domain.Mapper
import com.example.domain.status.model.LineStatus

class RoadStatusPresentationMapper:
    Mapper<LineStatus, RoadStatusPresentation> {

    override fun map(from: LineStatus): RoadStatusPresentation {
        return RoadStatusPresentation(
            id = from.id,
            name = from.name,
            severityLevel = from.severityLevel,
            severityLevelDescription = from.severityLevelDescription
        )
    }
}
