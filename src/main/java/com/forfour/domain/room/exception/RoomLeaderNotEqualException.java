package com.forfour.domain.room.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.room.exception.ErrorMessage.ROOM_LEADER_NOT_EQUAL;

public class RoomLeaderNotEqualException extends BaseException {
    public RoomLeaderNotEqualException() {
        super(ROOM_LEADER_NOT_EQUAL.getStatus(), ROOM_LEADER_NOT_EQUAL.getMessage());
    }
}
