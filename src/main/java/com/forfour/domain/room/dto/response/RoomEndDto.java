package com.forfour.domain.room.dto.response;

import com.forfour.domain.path.entity.Path;
import com.forfour.domain.room.entity.Room;
import lombok.Builder;

@Builder
public record RoomEndDto(
    long minutes,
    double distance,
    RoomEndDetailDto roomDetail
) {
    public static RoomEndDto of(Room room, Path path) {
        long minutes = room.getDuration().toMinutes();

        return RoomEndDto.builder()
                .minutes(minutes)
                .distance(path.getDistance())
                .roomDetail(RoomEndDetailDto.of(room, path))
                .build();
    }
}
