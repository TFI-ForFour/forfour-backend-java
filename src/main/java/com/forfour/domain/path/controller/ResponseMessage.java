package com.forfour.domain.path.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    PATH_CREATED("[산책 경로]를 생성했습니다."),
    ;

    private final String message;

}
