package com.forfour.domain.member.dto.response;

import com.forfour.domain.member.entity.Member;
import com.forfour.domain.member.entity.Role;
import lombok.Builder;

@Builder
public record MemberDetailDto(
        Long id,
        String nickname,
        Role role,
        long totalWalkCount,
        double totalDistance
) {
    public static MemberDetailDto from(Member member) {
        return MemberDetailDto.builder()
                .id(id)
                .nickname(nickname)
                .role(role)
                .totalWalkCount(totalWalkCount)
                .totalDistance(totalDistance)
                .build();
    }
}
