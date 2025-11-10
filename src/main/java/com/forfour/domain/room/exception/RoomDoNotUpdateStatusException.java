package com.forfour.domain.room.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.room.exception.ErrorMessage.ROOM_DO_NOT_UPDATE_STATUS;

public class RoomDoNotUpdateStatusException extends BaseException {
    public RoomDoNotUpdateStatusException(String status) {
        super(ROOM_DO_NOT_UPDATE_STATUS.getStatus(), status + ROOM_DO_NOT_UPDATE_STATUS.getMessage());
    }
}
