package com.forfour.domain.room.dto.response;

import com.forfour.domain.path.entity.Path;
import com.forfour.domain.room.entity.Room;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RoomEndDetailDto(
        Long roomId,
        String title,
        String missionName,
        String pathImageUrl,
        LocalDateTime startAt
) {
    public static RoomEndDetailDto of(Room room, Path path) {
        return RoomEndDetailDto.builder()
                .roomId(room.getId())
                .title(room.getTitle())
                .missionName(room.getMission().name())
                .pathImageUrl(path.getPathImageUrl())
                .startAt(room.getStartAt())
                .build();
    }
}
