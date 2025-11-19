package com.forfour.domain.member.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    MEMBER_REGISTER_SUCCESS("성공적으로 회원가입 했습니다."),
    MEMBER_LOGIN_SUCCESS("성공적으로 로그인 했습니다."),
    MEMBER_READ_SUCCESS("회원 정보를 조회합니다."),
    NICKNAME_UPDATE_SUCCESS("닉네임을 수정했습니다."),
    ;

    private final String message;

}
