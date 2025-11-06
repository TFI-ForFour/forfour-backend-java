package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.EXPIRED_JWT;

public class CustomExpiredJwtException extends AuthException {
    public CustomExpiredJwtException() {
        super(EXPIRED_JWT.getStatus(), EXPIRED_JWT.getMessage());
    }
}
