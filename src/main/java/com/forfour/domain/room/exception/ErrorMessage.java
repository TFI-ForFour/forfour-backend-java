package com.forfour.domain.room.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "[산책 방]을 찾을 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;

}
