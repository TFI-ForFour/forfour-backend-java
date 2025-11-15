package com.forfour.domain.room.event;

import com.forfour.domain.room.entity.RoomStatus;
import lombok.Builder;

@Builder
public record RoomStartEvent(
        Long roomId,
        RoomStatus status
) {
    public static RoomStartEvent of(final Long roomId, final RoomStatus status) {
        return RoomStartEvent.builder()
                .roomId(roomId)
                .status(status)
                .build();
    }
}
