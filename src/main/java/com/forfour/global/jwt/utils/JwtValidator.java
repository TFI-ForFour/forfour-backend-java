package com.forfour.global.jwt.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.forfour.global.common.exception.BaseException;
import com.forfour.global.jwt.exception.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;

@Component
public class JwtValidator {

    private final Key key;

    public JwtValidator(@Value("${forfour.jwt.secretKey}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public void verifyAccessToken(String token) {
        try{
            Jwts.parser()
                    .verifyWith((SecretKey) key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }catch (ExpiredJwtException e) {
            throw BaseException.from(AuthExceptionInformation.EXPIRED_JWT);
        } catch (UnsupportedJwtException e) {
            throw BaseException.from(AuthExceptionInformation.UN_SUPPORTED_JWT);
        } catch (MalformedJwtException e) {
            throw BaseException.from(AuthExceptionInformation.MALFORMED_JWT);
        } catch (SignatureException e) {
            throw BaseException.from(AuthExceptionInformation.SIGNATURE_JWT);
        } catch (IllegalArgumentException e) {
            throw BaseException.from(AuthExceptionInformation.ILLEGAL_ARGUMENT);
        } catch (WeakKeyException e) {
            throw BaseException.from(AuthExceptionInformation.WEAK_KEY);
        } catch (Exception e) {
            throw BaseException.from(AuthExceptionInformation.CAUSE_UNKNOWN);
        }
    }

}