package com.forfour.domain.mission.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 [미션]을 찾을 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;

}
