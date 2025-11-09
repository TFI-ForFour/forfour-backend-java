package com.forfour.domain.member.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.member.exception.ErrorMessage.MEMBER_NOT_FOUND;

public class MemberNotFoundException extends BaseException {
    public MemberNotFoundException() {
        super(MEMBER_NOT_FOUND.getStatus(), MEMBER_NOT_FOUND.getMessage());
    }
}
