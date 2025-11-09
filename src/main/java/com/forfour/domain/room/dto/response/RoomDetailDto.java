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
        String missionName,
        int maxMemberCount,
        int memberCount,
        RoomStatus status,
        LocalDateTime startAt
) {
    public static RoomDetailDto of(Room room, Member leader) {
        return RoomDetailDto.builder()
                .roomId(room.getId())
                .title(room.getTitle())
                .leaderId(leader.getId())
                .leaderName(leader.getNickname())
                .pathId(room.getPathId())
                .missionName(room.getMission().name())
                .maxMemberCount(room.getMaxMemberCount())
                .memberCount(room.getMemberCount())
                .status(room.getStatus())
                .startAt(room.getStartAt())
                .build();
    }

    public static RoomDetailDto from(Room room) {
        return RoomDetailDto.builder()
                .roomId(room.getId())
                .title(room.getTitle())
                .leaderId(room.getLeader().getId())
                .leaderName(room.getLeader().getNickname())
                .pathId(room.getPathId())
                .missionName(room.getMission().name())
                .status(room.getStatus())
                .startAt(room.getStartAt())
                .build();
    }
}
