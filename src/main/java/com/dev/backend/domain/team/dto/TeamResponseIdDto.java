package com.dev.backend.domain.team.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Builder
public class TeamResponseIdDto {
    private AtomicLong id;

    public static TeamResponseIdDto fromEntity(AtomicLong id){
        return TeamResponseIdDto.builder()
                .id(id)
                .build();
    }
}
