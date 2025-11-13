package com.forfour.domain.member.exception;

import com.forfour.global.common.exception.BaseException;
import com.forfour.global.common.exception.ExceptionInformation;

public class MemberException extends BaseException {
    public MemberException(ExceptionInformation information) {
        super(information);
    }
}
