package com.forfour.domain.room.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.room.exception.ErrorMessage.ROOM_IS_FULL;

public class RoomIsFullException extends BaseException {
    public RoomIsFullException() {
        super(ROOM_IS_FULL.getStatus(), ROOM_IS_FULL.getMessage());
    }
}
