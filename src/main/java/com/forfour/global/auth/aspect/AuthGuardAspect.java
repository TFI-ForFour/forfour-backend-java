package com.forfour.global.auth.aspect;

import com.forfour.domain.member.entity.Role;
import com.forfour.global.auth.annotations.AuthGuard;
import com.forfour.global.auth.context.MemberContext;
import com.forfour.global.auth.guards.Authorizable;
import com.forfour.global.common.exception.BaseException;
import com.forfour.global.jwt.dto.JwtTokenClaimsDto;
import com.forfour.global.jwt.exception.AuthExceptionInformation;
import com.forfour.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class AuthGuardAspect {

    private final ApplicationContext applicationContext;
    private final JwtService jwtService;

    @Around("@annotation(authGuard)")
    public Object applyGuards(ProceedingJoinPoint joinPoint, AuthGuard authGuard) throws Throwable {
        // 토큰 추출
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = jwtService.extractJwtToken(httpServletRequest);
        jwtService.isValidToken(token);
        JwtTokenClaimsDto memberClaims = jwtService.extractJwtToken(token);


        // 인가 검증 후 Context 저장
        authorize(authGuard.value(), memberClaims.role());
        MemberContext.setCurrentMemberClaims(memberClaims);

        // 본문 실행
        Object proceed = joinPoint.proceed();

        // Context Clear
        MemberContext.clear();

        return proceed;
    }

    public void authorize(Class<? extends Authorizable>[] authGuards, Role tokenRole) {
        boolean isAuthorized = Arrays.stream(authGuards)
                .map(applicationContext::getBean)
                .anyMatch(guard -> guard.isAuthorized(tokenRole));

        if (!isAuthorized) {
            throw BaseException.from(AuthExceptionInformation.UN_AUTHORIZED);
        }
    }

}
