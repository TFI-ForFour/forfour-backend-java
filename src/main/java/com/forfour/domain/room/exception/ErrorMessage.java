package com.forfour.domain.room.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "[산책 방]을 찾을 수 없습니다."),
    ROOM_IS_NOT_RECRUITING(HttpStatus.BAD_REQUEST, "[산책 방]이 현재 모집 중이 아닙니다."),
    ROOM_IS_FULL(HttpStatus.BAD_REQUEST, "[산책 방]의 회원수가 초과됐습니다."),
    ROOM_DO_NOT_UPDATE_STATUS(HttpStatus.BAD_REQUEST, "에는 산책방 상태를 변경할 수 없습니다."),
    ROOM_NOT_ENOUGH_MINIMUM_MEMBER(HttpStatus.BAD_REQUEST, "[산책 방]의 최소 인원을 만족하지 못했습니다."),

    ROOM_RECRUIT_STRATEGY_NOT_MATCH(HttpStatus.BAD_REQUEST, "[모집 중], 혹은 [모집 종료]으로만 변경 가능합니다."),
    ROOM_LEADER_NOT_EQUAL(HttpStatus.BAD_REQUEST, "산책 방의 [방장]이 아닙니다."),
    ;

    private final HttpStatus status;
    private final String message;

}
