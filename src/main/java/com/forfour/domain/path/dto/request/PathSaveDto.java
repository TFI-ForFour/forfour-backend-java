package com.forfour.domain.path.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record PathSaveDto(

        @NotNull
        @Schema(description = "산책 코스 이름", example = "신나는 산책 코스")
        String pathName,

        @NotNull
        @Schema(description = "산책 코스 거리(km)", example = "1.7")
        double distance,

        @NotNull
        @Schema(description = "산책 시작 지점(가게)")
        String startMarketId,

        @NotNull
        @Schema(description = "산책 종료 지점(가게)")
        String endMarketId,

        String pathImageUrl

) {
}
