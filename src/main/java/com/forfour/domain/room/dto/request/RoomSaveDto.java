package com.forfour.domain.room.dto.request;

import java.time.LocalDateTime;

public record RoomSaveDto(
        String title,
        Long pathId,
        Long missionId,
        LocalDateTime startAt
) {
}
