package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.WEAK_KEY;

public class CustomWeakKeyException extends AuthException {
    public CustomWeakKeyException() {
        super(WEAK_KEY.getStatus(), WEAK_KEY.getMessage());
    }
}
