package com.forfour.domain.member.exception;

import com.forfour.global.common.exception.ExceptionInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberExceptionInformation implements ExceptionInformation {

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"MEM-001", "[회원]을 찾을 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
