package com.forfour.domain.room.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    ROOM_CREATED("[산책 방]을 생성했습니다."),
    ROOM_PARTICIPANT("[산책 방]에 참여했습니다."),
    ;

    private final String meesage;

}
