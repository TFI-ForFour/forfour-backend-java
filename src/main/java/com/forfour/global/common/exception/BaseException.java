package com.forfour.global.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final String code;

    private BaseException(final HttpStatus status, String code, final String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public static BaseException from(ExceptionInformation info) {
        return new BaseException(info.getHttpStatus(), info.getCode(), info.getMessage());
    }

}