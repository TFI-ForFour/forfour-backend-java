package com.forfour.global.jwt.service;

import com.forfour.domain.member.entity.Role;
import com.forfour.global.jwt.JwtTokenType;
import com.forfour.global.jwt.dto.JwtTokenClaimsDto;
import com.forfour.global.jwt.dto.JwtTokenResponseDto;
import com.forfour.global.jwt.exception.NotFoundJwtTokenException;
import com.forfour.global.jwt.utils.JwtExtractor;
import com.forfour.global.jwt.utils.JwtProvider;
import com.forfour.global.jwt.utils.JwtValidator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtProvider jwtProvider;
    private final JwtValidator jwtValidator;
    private final JwtExtractor jwtExtractor;

    public JwtTokenResponseDto generateJwtToken(Long memberId, Role role) {
        String accessToken = jwtProvider.generateToken(JwtTokenType.ACCESS_TOKEN, memberId, role.name());

        return JwtTokenResponseDto.of(accessToken);
    }

    public String extractJwtToken(HttpServletRequest request) {
        return jwtExtractor.extractJwtToken(request)
                .orElseThrow(NotFoundJwtTokenException::new);
    }

    // 유효하지 않은 경우 예외 처리 -> void 반환.
    public void isValidToken(String token) {
        jwtValidator.verifyAccessToken(token);
    }

    public JwtTokenClaimsDto extractJwtToken(String token) {
        Long id = jwtExtractor.getId(token);
        String role = jwtExtractor.getRole(token);
        return JwtTokenClaimsDto.of(id, role);
    }

}
