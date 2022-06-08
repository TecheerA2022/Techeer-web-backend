package com.dev.backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private String message;
    private LocalDateTime timestamp;
    private HttpStatus status;
}
