package com.forfour.domain.participant.entity;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.room.entity.Room;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long room_id;

    private Long memberId;

    private String memberName; // 정합성 관리 필요.

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    public static Participant of(Long roomId, Long memberId) {
        return Participant.builder()
                .room_id(roomId)
                .memberId(memberId)
                .roomStatus(RoomStatus.RECRUITING)
                .build();
    }

}
