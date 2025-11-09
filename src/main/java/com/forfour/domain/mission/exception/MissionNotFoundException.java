package com.forfour.domain.mission.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.mission.exception.ErrorMessage.MISSION_NOT_FOUND;

public class MissionNotFoundException extends BaseException {
    public MissionNotFoundException() {
        super(MISSION_NOT_FOUND.getStatus(), MISSION_NOT_FOUND.getMessage());
    }
}
