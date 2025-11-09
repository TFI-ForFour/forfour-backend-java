package com.forfour.domain.path.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    PATH_CREATED("[산책 경로]를 생성했습니다."),
    SINGLE_PATH_READ("[산책 경로]를 조회합니다."),
    PATH_SCROLL_LIST_READ("[산책 경로] 목록을 조회합니다.")
    ;

    private final String message;

}
