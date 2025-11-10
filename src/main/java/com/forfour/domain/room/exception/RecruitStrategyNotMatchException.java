package com.forfour.domain.room.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.room.exception.ErrorMessage.ROOM_RECRUIT_STRATEGY_NOT_MATCH;

public class RecruitStrategyNotMatchException extends BaseException {
    public RecruitStrategyNotMatchException() {
        super(ROOM_RECRUIT_STRATEGY_NOT_MATCH.getStatus(), ROOM_RECRUIT_STRATEGY_NOT_MATCH.getMessage());
    }
}
