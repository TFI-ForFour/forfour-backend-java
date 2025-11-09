package com.forfour.domain.participant.dto.response;

import com.forfour.domain.member.entity.Member;
import lombok.Builder;

@Builder
public record ParticipantDetailDto(
        Long memberId,
        String memberNickName
) {
    public static ParticipantDetailDto from(Member participant) {
        return ParticipantDetailDto.builder()
                .memberId(participant.getId())
                .memberNickName(participant.getNickname())
                .build();
    }
}
