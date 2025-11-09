package com.forfour.domain.room.controller;

import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.dto.response.RoomDetailDto;
import com.forfour.domain.room.dto.response.RoomWithParticipantsDto;
import com.forfour.domain.room.dto.response.SliceRoomDto;
import com.forfour.domain.room.entity.RoomStatus;
import com.forfour.domain.room.facade.RoomFacade;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.forfour.domain.room.controller.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomSwagger{

    private final RoomFacade facade;

    @AuthGuard({MemberGuard.class, AdminGuard.class})
    @PostMapping("/v1/room")
    public ApiResponse<RoomDetailDto> createRoom(
            @RequestBody @Validated RoomSaveDto dto
    ) {
        RoomDetailDto response = facade.createRoom(dto);
        return ApiResponse.response(HttpStatus.OK, ROOM_CREATED.getMeesage(), response);
    }

    @AuthGuard({MemberGuard.class, AdminGuard.class})
    @PostMapping("/v1/room/{roomId}/participant")
    public ApiResponse<Void> participateRoom(
            @PathVariable Long roomId
    ) {
        facade.participateRoom(roomId);
        return ApiResponse.response(HttpStatus.OK, ROOM_CREATED.getMeesage());
    }

    @AuthGuard({MemberGuard.class, AdminGuard.class})
    @GetMapping("/v1/room/{roomId}")
    public ApiResponse<RoomWithParticipantsDto> readRoom(
            @PathVariable Long roomId
    ) {
        RoomWithParticipantsDto response = facade.readRoom(roomId);
        return ApiResponse.response(HttpStatus.OK, ROOM_READ.getMeesage() , response);
    }

    @AuthGuard({MemberGuard.class, AdminGuard.class})
    @GetMapping("/v1/room-list")
    public ApiResponse<SliceRoomDto> scrollRoom(
            @RequestParam int pageSize,
            @RequestParam int pageNum,
            @Schema(implementation = RoomStatus.class)
            @RequestParam @Nullable String roomStatus
    ) {
        SliceRoomDto response = facade.readRoomScrollList(pageSize, pageNum, roomStatus);
        return ApiResponse.response(HttpStatus.OK, ROOM_SCROLL_LIST_READ.getMeesage(), response);
    }

}
