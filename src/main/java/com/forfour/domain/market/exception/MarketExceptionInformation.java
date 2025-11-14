package com.forfour.domain.market.exception;

import com.forfour.global.common.exception.ExceptionInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MarketExceptionInformation implements ExceptionInformation {

    MARKET_NOT_FOUND(HttpStatus.NOT_FOUND, "MAR-001", "[가게]를 찾을 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
