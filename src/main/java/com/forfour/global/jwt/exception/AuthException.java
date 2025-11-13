package com.forfour.global.jwt.exception;

import com.forfour.global.common.exception.BaseException;
import com.forfour.global.common.exception.ExceptionInformation;

public class AuthException extends BaseException {
    public AuthException(ExceptionInformation information) {
        super(information);
    }
}
