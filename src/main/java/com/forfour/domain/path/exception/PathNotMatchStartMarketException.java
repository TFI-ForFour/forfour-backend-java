package com.forfour.domain.path.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.path.exception.ErrorMessage.PATH_NOT_MATCH_START_MARKET;

public class PathNotMatchStartMarketException extends BaseException {
    public PathNotMatchStartMarketException() {
        super(PATH_NOT_MATCH_START_MARKET.getStatus(), PATH_NOT_MATCH_START_MARKET.getMessage());
    }
}
