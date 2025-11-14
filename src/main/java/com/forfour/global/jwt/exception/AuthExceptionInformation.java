package com.forfour.global.jwt.exception;

import com.forfour.global.common.exception.ExceptionInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
@AllArgsConstructor
public enum AuthExceptionInformation implements ExceptionInformation {

    UN_AUTHORIZED(FORBIDDEN, "ATH-001", "잘못된 권한 요청입니다."),
    NOT_EXIST_TOKEN(UNAUTHORIZED, "ATH-002", "JWT 토큰이 존재하지 않습니다."),
    EXPIRED_JWT(UNAUTHORIZED, "ATH-003", "JWT 토큰이 만료되었습니다."),
    UN_SUPPORTED_JWT(UNAUTHORIZED, "ATH-004", "지원되지 않는 JWT 토큰입니다."),
    MALFORMED_JWT(UNAUTHORIZED, "ATH-005", "잘못된 형식의 JWT 토큰입니다."),
    SIGNATURE_JWT(UNAUTHORIZED, "ATH-006", "JWT 서명 검증에 실패했습니다."),
    ILLEGAL_ARGUMENT(UNAUTHORIZED, "ATH-007", "잘못된 JWT 토큰입니다."),
    WEAK_KEY(UNAUTHORIZED, "ATH-008", "JWT 서명 KEY가 너무 약합니다."),
    CAUSE_UNKNOWN(UNAUTHORIZED, "ATH-009", "원인 미상의 오류가 발생했습니다."),

    NOT_FOUND_JWT_TOKEN(UNAUTHORIZED, "ATH-010", "요청 헤더로부터 JWT 토큰을 찾을 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
