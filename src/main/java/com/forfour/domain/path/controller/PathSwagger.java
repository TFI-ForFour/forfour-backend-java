package com.forfour.domain.path.controller;

import com.forfour.domain.path.dto.request.PathSaveDto;
import com.forfour.domain.path.dto.response.PathDetailDto;
import com.forfour.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "산책 경로")
public interface PathSwagger {

    @Operation(description = "산책 경로 등록 API")
    ApiResponse<PathDetailDto> createWalkingPath(@RequestBody @Validated PathSaveDto dto);

    @Operation(description = "산책 경로 단일 조회 API")
    ApiResponse<PathDetailDto> readWalkingPath(@PathVariable Long pathId);

}
