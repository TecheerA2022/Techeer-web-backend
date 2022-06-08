package com.dev.backend.domain.user.exception;

import com.dev.backend.global.exception.BaseException;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.dev.backend.domain.user.exception.MemberExceptionType.ALREADY_EXIST_USER_ID;

@Getter
public class AlreadyExistUserIdException extends BaseException {
    public AlreadyExistUserIdException() {
        super(ALREADY_EXIST_USER_ID.getMessage(), LocalDateTime.now(), ALREADY_EXIST_USER_ID.getStatus());
    }
}
