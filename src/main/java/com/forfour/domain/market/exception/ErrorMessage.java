package com.forfour.domain.market.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    MARKET_NOT_FOUND(HttpStatus.NOT_FOUND, "[가게]를 찾을 수 없습니다."),
    ;


    private final HttpStatus status;
    private final String message;

}
