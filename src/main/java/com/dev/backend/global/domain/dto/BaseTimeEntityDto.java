package com.dev.backend.global.domain.dto;


import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public abstract class BaseTimeEntityDto {

    @NotNull
    private LocalDateTime createdOn;

    @NotNull
    private LocalDateTime updateOn;
}
