package com.forfour.domain.room.entity;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.exception.*;
import com.forfour.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room extends BaseEntity {

    private static final int MINIMUM_MEMBER_COUNT = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leaderId", referencedColumnName = "id")
    private Member leader;

    private Long pathId;

    private Mission mission;

    private int maxMemberCount;

    private int memberCount;

    private boolean isActive;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    private LocalDateTime startAt;

    private LocalDateTime stopwatchStartAt;

    private LocalDateTime stopwatchEndAt;

    public static Room of(RoomSaveDto dto, Member leader) {
        return Room.builder()
                .title(dto.title())
                .leader(leader)
                .pathId(dto.pathId())
                .mission(Mission.value(dto.missionName()))
                .maxMemberCount(dto.maxMemberCount())
                .memberCount(1)
                .status(RoomStatus.RECRUITING)
                .startAt(dto.startAt())
                .isActive(true)
                .build();
    }

    public void checkParticipate() {
        if (status != RoomStatus.RECRUITING) {
            throw new RoomException(RoomExceptionInformation.ROOM_IS_NOT_RECRUITING);
        }

        if (this.memberCount == this.maxMemberCount) {
            throw new RoomException(RoomExceptionInformation.ROOM_IS_FULL);
        }
    }

    public void increaseMemberCount() {
        this.memberCount++;
    }

    public void closed() {
        this.isActive = false;
    }

    public void validateRoomLeader(Long memberId) {
        if(this.leader.getId() != memberId) {
            throw new RoomException(RoomExceptionInformation.ROOM_LEADER_NOT_EQUAL);
        }
    }

    public boolean checkStatus(RoomStatus status) {
        return this.status == status;
    }

    public void endStopWatch() {
        this.stopwatchEndAt = LocalDateTime.now();
    }

    public Duration getDuration() {
        return Duration.between(stopwatchStartAt, stopwatchEndAt);
    }

    public void updateStatus(RoomStatus status) {
        this.status = status;
    }

    public void validateMinimumMember() {
        if (this.memberCount < MINIMUM_MEMBER_COUNT) {
            throw new RoomException(RoomExceptionInformation.ROOM_NOT_ENOUGH_MINIMUM_MEMBER);
        }
    }

}
