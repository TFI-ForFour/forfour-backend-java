package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.UN_AUTHORIZED;

public class AuthorizationException extends AuthException {
    public AuthorizationException() {
        super(UN_AUTHORIZED.getStatus(), UN_AUTHORIZED.getMessage());
    }
}
