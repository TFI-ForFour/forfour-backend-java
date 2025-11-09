package com.forfour.domain.room.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.room.exception.ErrorMessage.ROOM_NOT_FOUND;

public class RoomNotFoundException extends BaseException {
    public RoomNotFoundException() {
        super(ROOM_NOT_FOUND.getStatus(), ROOM_NOT_FOUND.getMessage());
    }
}
