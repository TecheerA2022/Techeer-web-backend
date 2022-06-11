package com.dev.backend.domain.user.exception;

import com.dev.backend.global.exception.BaseException;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.dev.backend.domain.user.exception.AuthExceptionType.WRONG_PASSWORD;

@Getter
public class WrongPasswordException extends BaseException {
    public WrongPasswordException() {
        super(WRONG_PASSWORD.getMessage(), LocalDateTime.now(), WRONG_PASSWORD.getStatus());
    }
}
