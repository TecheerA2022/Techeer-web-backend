package com.dev.backend.domain.user.exception;

import com.dev.backend.global.exception.BaseException;

import java.time.LocalDateTime;

import static com.dev.backend.domain.user.exception.MemberExceptionType.NOT_EXIST_USER;

public class NotExistUserException extends BaseException {
    public NotExistUserException() {
        super(NOT_EXIST_USER.getMessage(), LocalDateTime.now(), NOT_EXIST_USER.getStatus());
    }
}
