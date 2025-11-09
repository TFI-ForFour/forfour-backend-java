package com.forfour.domain.participant.entity;

import com.forfour.domain.member.entity.Member;
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
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "UK_participant_room_member",
                columnNames = {"room_id", "memberId"}
        )
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", referencedColumnName = "id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    public static Participant of(Long roomId, Member member) {
        return Participant.builder()
                .roomId(roomId)
                .member(member)
                .roomStatus(RoomStatus.RECRUITING)
                .build();
    }

}
