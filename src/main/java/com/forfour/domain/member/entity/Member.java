package com.forfour.domain.member.entity;

import com.forfour.domain.member.utils.NicknameGenerator;
import com.forfour.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long kakaoId;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

    private long totalWalkCount;

    private double totalDistance;

    public static Member from(Long kakaoId) {
        return Member.builder()
                .kakaoId(kakaoId)
                .nickname(NicknameGenerator.generate())
                .role(Role.MEMBER)
                .totalWalkCount(0)
                .totalDistance(0)
                .build();
    }

}
