package com.forfour.domain.member.dto.response;

import com.forfour.domain.member.entity.Member;
import com.forfour.global.jwt.dto.JwtTokenResponseDto;
import lombok.Builder;

@Builder
public record MemberEnterDto(
        Long memberId,
        String nickName,
        long totalWalkCount,
        double totalDistance,
        JwtTokenResponseDto jwtToken,
        boolean isRegistered
) {
    public static MemberEnterDto of(final Member member, JwtTokenResponseDto jwtTokenDto, boolean isRegistered) {
        return MemberEnterDto.builder()
                .memberId(member.getId())
                .nickName(member.getNickname())
                .totalWalkCount(member.getTotalWalkCount())
                .totalDistance(member.getTotalDistance())
                .jwtToken(jwtTokenDto)
                .isRegistered(isRegistered)
                .build();
    }

    public boolean isRegistered() {
        return isRegistered;
    }
}
