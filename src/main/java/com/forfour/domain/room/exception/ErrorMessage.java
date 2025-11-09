package com.forfour.domain.room.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "[산책 방]을 찾을 수 없습니다."),
    ROOM_IS_NOT_RECRUITING(HttpStatus.BAD_REQUEST, "[산책 방]이 현재 모집 중이 아닙니다."),
    ROOM_IS_FULL(HttpStatus.BAD_REQUEST, "[산책 방]의 회원수가 초과됐습니다."),
    ;

    private final HttpStatus status;
    private final String message;

}
