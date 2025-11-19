package com.forfour.domain.participant.dto.response;

import com.forfour.domain.room.entity.Room;
import lombok.Builder;

@Builder
public record MyParticipationDto(
        boolean hasActiveRoom,
        Long roomId
) {
    public static MyParticipationDto from(boolean hasActiveRoom, Room room) {
        return MyParticipationDto.builder()
                .hasActiveRoom(hasActiveRoom)
                .roomId(room.getId())
                .build();
    }
}
