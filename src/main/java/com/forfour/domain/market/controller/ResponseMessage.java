package com.forfour.domain.market.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    MARKET_CREATED("[가게]를 등록했습니다."),
    ;

    private final String message;

}
