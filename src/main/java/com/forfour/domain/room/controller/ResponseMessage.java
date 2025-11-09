package com.forfour.domain.room.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    ROOM_CREATED("[산책 방]을 생성했습니다."),
    ROOM_PARTICIPANT("[산책 방]에 참여했습니다."),
    ROOM_SCROLL_LIST_READ("[산책 방]에 목록을 조회합니다."),
    ROOM_READ("[산책 방 + 참여자 정보]를 조회합니다."),
    ;

    private final String meesage;

}
