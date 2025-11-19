package com.forfour.domain.participant.dto.response;

import lombok.Builder;

@Builder
public record MyParticipationDto(
        boolean hasActiveRoom,
        Long roomId
) {
    public static MyParticipationDto from(boolean hasActiveRoom, Long roomId) {
        return MyParticipationDto.builder()
                .hasActiveRoom(hasActiveRoom)
                .roomId(roomId)
                .build();
    }
}
