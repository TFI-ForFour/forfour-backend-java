package com.forfour.global.jwt.exception;


import static com.forfour.global.jwt.exception.AuthErrorMessage.SIGNATURE_JWT;

public class CustomSignatureException extends AuthException {
    public CustomSignatureException() {
        super(SIGNATURE_JWT.getStatus(), SIGNATURE_JWT.getMessage());
    }
}
