package com.dev.backend.domain.team.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Builder
public class TeamResponseIdDto {
    private Long id;

    public static TeamResponseIdDto fromEntity(Long id){
        return TeamResponseIdDto.builder()
                .id(id)
                .build();
    }
}
