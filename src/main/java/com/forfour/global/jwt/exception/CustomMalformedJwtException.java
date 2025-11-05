package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.MALFORMED_JWT;

public class CustomMalformedJwtException extends AuthException {
    public CustomMalformedJwtException() {
        super(MALFORMED_JWT.getStatus(), MALFORMED_JWT.getMessage());
    }
}
