package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.NOT_FOUND_JWT_TOKEN;

public class NotFoundJwtTokenException extends AuthException {
    public NotFoundJwtTokenException() {
        super(NOT_FOUND_JWT_TOKEN.getStatus(), NOT_FOUND_JWT_TOKEN.getMessage());
    }
}
