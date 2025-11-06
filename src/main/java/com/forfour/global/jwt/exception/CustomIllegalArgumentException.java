package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.ILLEGAL_ARGUMENT;

public class CustomIllegalArgumentException extends AuthException {
    public CustomIllegalArgumentException() {
        super(ILLEGAL_ARGUMENT.getStatus(), ILLEGAL_ARGUMENT.getMessage());
    }
}
