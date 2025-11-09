package com.forfour.domain.path.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.path.exception.ErrorMessage.PATH_NOT_MATCH_END_MARKET;

public class PathNotMatchEndMarketException extends BaseException {
    public PathNotMatchEndMarketException() {
        super(PATH_NOT_MATCH_END_MARKET.getStatus(), PATH_NOT_MATCH_END_MARKET.getMessage());
    }
}
