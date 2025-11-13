package com.forfour.global.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final String code;

    protected BaseException(ExceptionInformation info) {
        super(info.getMessage());
        this.code = info.getCode();
        this.status = info.getHttpStatus();
    }

    public static BaseException from(ExceptionInformation info) {
        return new BaseException(info);
    }

}