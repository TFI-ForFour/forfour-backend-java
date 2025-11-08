package com.forfour.domain.room.entity;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.path.entity.Path;
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

    private Long missionId; // THINK 그냥 missionName 때려박아도 상관없지않을까?

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    private LocalDateTime startAt;

    private LocalDateTime stopwatchStartAt;

    private LocalDateTime stopwatchEndAt;

}
