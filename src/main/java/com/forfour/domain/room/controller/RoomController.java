package com.forfour.domain.room.controller;

import com.forfour.domain.room.dto.request.RoomSaveDto;
import com.forfour.domain.room.dto.response.RoomDetailDto;
import com.forfour.domain.room.facade.RoomFacade;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.guards.AdminGuard;
import com.forfour.global.auth.guards.MemberGuard;
import com.forfour.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.forfour.domain.room.controller.ResponseMessage.ROOM_CREATED;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomSwagger{

    private final RoomFacade facade;

    @AuthGuard({MemberGuard.class, AdminGuard.class})
    @PostMapping("/v1/room")
    public ApiResponse<RoomDetailDto> createRoom(
            @RequestBody RoomSaveDto dto
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

}
