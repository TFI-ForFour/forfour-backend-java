package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.CAUSE_UNKNOWN;

public class CustomJwtUnknownException extends AuthException {
    public CustomJwtUnknownException() {
        super(CAUSE_UNKNOWN.getStatus(), CAUSE_UNKNOWN.getMessage());
    }
}
