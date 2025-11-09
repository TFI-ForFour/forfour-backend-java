package com.forfour.domain.room.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RoomSaveDto(
        @NotBlank
        @Schema(description = "산책방 제목", example = "테스트 산책방 1")
        String title,

        @NotBlank
        @Schema(description = "경로 ID", example = "1")
        Long pathId,

        @Schema(description = "미션 명", example = "PLOGGING, DELIVERY, PARK, NO_MISSION")
        String missionName,

        @NotNull
        @Schema(description = "최대 멤버 수", example = "10")
        Integer maxMemberCount,

        @NotNull
        @Schema(description = "산책 시간")
        LocalDateTime startAt
) {
}
