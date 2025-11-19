package com.forfour.domain.participant.controller;

import com.forfour.domain.participant.dto.response.MyParticipationDto;
import com.forfour.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "참여")
public interface ParticipantSwagger {

    @Operation(description = "내가 산책 중인지 확인", summary = "내가 산책 중인지 확인")
    ApiResponse<MyParticipationDto> checkMyParticipation();

}
