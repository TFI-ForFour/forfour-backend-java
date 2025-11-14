package com.forfour.domain.market.exception;

import com.forfour.global.common.exception.BaseException;
import com.forfour.global.common.exception.ExceptionInformation;

public class MarketException extends BaseException {
    public MarketException(ExceptionInformation information) {
        super(information);
    }
}
