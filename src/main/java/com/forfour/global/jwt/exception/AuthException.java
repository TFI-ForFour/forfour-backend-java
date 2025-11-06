package com.forfour.global.jwt.exception;

import com.forfour.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

public class AuthException extends BaseException {

    public AuthException(HttpStatus status, String message) {
        super(status, message);
    }

}
