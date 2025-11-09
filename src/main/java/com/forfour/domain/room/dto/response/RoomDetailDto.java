package com.forfour.domain.room.dto.response;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RoomDetailDto(
        Long roomId,
        String title,
        Long leaderId,
        String leaderName,
        Long pathId,
        Long missionId,
        RoomStatus status,
        LocalDateTime startAt
) {
    public static RoomDetailDto from(Room room, Member leader) {
        return RoomDetailDto.builder()
                .roomId(room.getId())
                .title(room.getTitle())
                .leaderId(room.getLeaderId())
                .leaderName(leader.getNickname())
                .pathId(room.getPathId())
                .missionId(room.getMissionId())
                .status(room.getStatus())
                .startAt(room.getStartAt())
                .build();
    }
}
