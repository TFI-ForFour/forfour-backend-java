package com.forfour.domain.member.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"[회원]을 찾을 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
