package com.dev.backend.domain.team.dto;

import com.dev.backend.domain.team.Team;
import com.dev.backend.global.domain.dto.BaseTimeEntityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDto{

    private Long id;
    private String teamName;
    private Integer teamYear;
    private Integer teamSemester;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;

    public TeamResponseDto(Team entity){
        this.id = entity.getId();
        this.teamName = entity.getTeamName();
        this.teamYear = entity.getTeamYear();
        this.teamSemester = entity.getTeamSemester();
        this.createOn = entity.getCreateOn();
        this.updateOn = entity.getUpdateOn();
    }

}
