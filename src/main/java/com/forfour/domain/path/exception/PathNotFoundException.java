package com.forfour.domain.path.exception;

import com.forfour.global.common.exception.BaseException;

import static com.forfour.domain.path.exception.ErrorMessage.PATH_NOT_FOUND;

public class PathNotFoundException extends BaseException {
    public PathNotFoundException() {
        super(PATH_NOT_FOUND.getStatus(), PATH_NOT_FOUND.getMessage());
    }
}
