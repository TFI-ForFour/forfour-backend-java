package com.forfour.domain.path.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    PATH_NOT_FOUND(HttpStatus.NOT_FOUND, "[산책 경로]를 찾을 수 없습니다."),
    PATH_NOT_MATCH_START_MARKET(HttpStatus.BAD_REQUEST, "산책 경로의 [시작 지점]이 아닙니다."),
    PATH_NOT_MATCH_END_MARKET(HttpStatus.BAD_REQUEST, "산책 경로의 [종료 지점]이 아닙니다."),
    ;


    private final HttpStatus status;
    private final String message;

}
