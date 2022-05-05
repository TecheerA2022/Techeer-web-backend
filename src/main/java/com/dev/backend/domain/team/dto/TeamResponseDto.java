package com.dev.backend.domain.team.dto;

import com.dev.backend.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDto {

    private AtomicLong id;
    private String teamName;
    private Integer teamYear;
    private Integer teamSemester;

    public TeamResponseDto(Team entity){
        this.id = entity.getId();
        this.teamName = entity.getTeamName();
        this.teamYear = entity.getTeamYear();
        this.teamSemester = entity.getTeamSemester();
    }

}
