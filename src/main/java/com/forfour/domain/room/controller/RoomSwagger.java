package com.forfour.domain.room.controller;

import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.dto.response.RoomDetailDto;
import com.forfour.domain.room.dto.response.RoomEndDto;
import com.forfour.domain.room.dto.response.RoomWithParticipantsDto;
import com.forfour.domain.room.dto.response.SliceRoomDto;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "산책 방")
public interface RoomSwagger {

    @Operation(description = "산책 방 생성 API", summary = "산책 방 생성 API")
    ApiResponse<RoomDetailDto> createRoom(@RequestBody RoomSaveDto dto);

    @Operation(description = "산책 방 참여 API", summary = "산책 방 참여 API")
    ApiResponse<Void> participateRoom(@PathVariable Long roomId);

    @Operation(description = "[산책 방 + 참여자 정보] 조회 API", summary = "[산책 방 + 참여자 정보] 조회 API")
    ApiResponse<RoomWithParticipantsDto> readRoom(@PathVariable Long roomId);

    @Operation(description = "내가 참여한 산책방 정보 조회 API", summary = "내가 참여한 산책방 정보 조회 API")
    ApiResponse<SliceRoomDto> readMyRoom(@RequestParam int pageSize, @RequestParam int pageNum);

    @Operation(description = "산책 방 목록 조회 API", summary = "산책 방 목록 조회 API")
    ApiResponse<SliceRoomDto> scrollRoom(
            @RequestParam int pageSize,
            @RequestParam int pageNum,
            @Schema(implementation = RoomStatus.class)
            @RequestParam @Nullable String roomStatus
    );

    @Operation(description = "산책 모집 상태 변경 API", summary = "산책 모집 상태 변경 API")
    ApiResponse<Void> updateRoomRecruitStatus(
            @PathVariable Long roomId,
            @Schema(example = "RECRUITING, RECRUITMENT_ENDED")
            @RequestParam String roomStatus
    );

    @Operation(description = "산책 시작 API", summary = "산책 시작 API")
    ApiResponse<Void> startWalking(
            @PathVariable Long roomId,
            @PathVariable String marketId
    );

    @Operation(description = "산책 종료 API", summary = "산책 종료 API")
    ApiResponse<RoomEndDto> endWalking(
            @PathVariable Long roomId,
            @PathVariable String marketId
    );

}
