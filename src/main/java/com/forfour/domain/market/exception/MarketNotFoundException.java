package com.forfour.domain.market.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.market.exception.ErrorMessage.MARKET_NOT_FOUND;

public class MarketNotFoundException extends BaseException {
    public MarketNotFoundException() {
        super(MARKET_NOT_FOUND.getStatus(), MARKET_NOT_FOUND.getMessage());
    }
}
