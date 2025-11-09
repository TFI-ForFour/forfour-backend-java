package com.forfour.domain.room.controller;

import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.dto.response.RoomDetailDto;
import com.forfour.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "산책 방")
public interface RoomSwagger {

    @Operation(description = "산책 방 생성 API", summary = "산책 방 생성 API")
    ApiResponse<RoomDetailDto> createRoom(@RequestBody RoomSaveDto dto);

}
