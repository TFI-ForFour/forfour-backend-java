package com.forfour.domain.room.event;

import com.forfour.domain.path.entity.Path;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import lombok.Builder;

@Builder
public record RoomEndEvent(
        Long roomId,
        RoomStatus status,
        double distance
) {
    public static RoomEndEvent of(Long roomId, RoomStatus status, double distance) {
        return RoomEndEvent.builder()
                .roomId(roomId)
                .status(status)
                .distance(distance)
                .build();
    }

    public static RoomEndEvent of(Room room, Path path) {
        return RoomEndEvent.builder()
                .roomId(room.getId())
                .status(RoomStatus.COMPLETED)
                .distance(path.getDistance())
                .build();
    }
}
