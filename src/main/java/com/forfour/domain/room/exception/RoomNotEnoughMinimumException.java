package com.forfour.domain.room.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.room.exception.ErrorMessage.ROOM_NOT_ENOUGH_MINIMUM_MEMBER;

public class RoomNotEnoughMinimumException extends BaseException {
    public RoomNotEnoughMinimumException() {
        super(ROOM_NOT_ENOUGH_MINIMUM_MEMBER.getStatus(), ROOM_NOT_ENOUGH_MINIMUM_MEMBER.getMessage());
    }
}
