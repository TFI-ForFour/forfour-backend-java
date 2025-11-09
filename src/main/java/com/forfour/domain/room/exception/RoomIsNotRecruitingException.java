package com.forfour.domain.room.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.room.exception.ErrorMessage.ROOM_IS_NOT_RECRUITING;

public class RoomIsNotRecruitingException extends BaseException {
    public RoomIsNotRecruitingException() {
        super(ROOM_IS_NOT_RECRUITING.getStatus(), ROOM_IS_NOT_RECRUITING.getMessage());
    }
}
