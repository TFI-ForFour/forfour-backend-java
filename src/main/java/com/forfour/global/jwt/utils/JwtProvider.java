package com.forfour.global.jwt.utils;


import com.forfour.global.auth.AuthConstant;
import com.forfour.global.jwt.JwtTokenType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


@Component
public class JwtProvider {

    private final Key key;

    public JwtProvider(@Value("${forfour.jwt.secretKey}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    @Value("${forfour.jwt.accessTokenExpiration}")
    private Long accessTokenExpiration;

    public String generateToken(JwtTokenType jwtTokenType, Long memberId, String role) {
        return Jwts.builder()
                .claim(AuthConstant.ID_CLAIM, memberId)
                .claim(AuthConstant.ROLE_CLAIM, role)
                .subject(String.valueOf(memberId))
                .issuedAt(new Date())
                .expiration(setExpireTime((jwtTokenType)))
                .signWith(key)
                .compact();
    }

    /*
     * 여러 Token이 추가 될 가능성을 고려 -> JwtTokenType별로 만료 기간 분리
     * */

    private Date setExpireTime(JwtTokenType jwtTokenType) {
        return switch (jwtTokenType) {
            case ACCESS_TOKEN -> new Date(System.currentTimeMillis() + accessTokenExpiration);
        };
    }

}
