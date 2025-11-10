package com.forfour.domain.room.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomStatus {

    RECRUITING("모집 중"),
    RECRUITMENT_ENDED("모집 종료"),
    CANCELED("산책 취소"),
    PROGRESS("산책 중"),
    COMPLETED("산책 완료"),
    ;

    private final String message;

}
