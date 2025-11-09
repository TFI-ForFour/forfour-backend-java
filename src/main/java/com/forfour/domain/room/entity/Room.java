package com.forfour.domain.room.entity;

import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.exception.RoomIsFullException;
import com.forfour.domain.room.exception.RoomIsNotRecruitingException;
import com.forfour.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long leaderId;

    private Long pathId;

    private Mission mission; // THINK 그냥 missionName 때려박아도 상관없지않을까?

    private int maxMemberCount;

    private int memberCount;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    private LocalDateTime startAt;

    private LocalDateTime stopwatchStartAt;

    private LocalDateTime stopwatchEndAt;

    public static Room of(RoomSaveDto dto, Long leaderId) {
        return Room.builder()
                .title(dto.title())
                .leaderId(leaderId)
                .pathId(dto.pathId())
                .mission(Mission.value(dto.missionName()))
                .maxMemberCount(dto.maxMemberCount())
                .memberCount(1)
                .status(RoomStatus.RECRUITING)
                .startAt(dto.startAt())
                .build();
    }

    public void checkParticipate() {
        if (status != RoomStatus.RECRUITING) {
            throw new RoomIsNotRecruitingException();
        }

        if (this.memberCount == this.maxMemberCount) {
            throw new RoomIsFullException();
        }
    }

    public void increaseMemberCount() {
        this.memberCount++;
    }

}
