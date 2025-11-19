package com.forfour.domain.participant.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    MY_PARTICIPATION("현재 산책중 여부를 확인합니다."),
    ;

    private final String message;

}
