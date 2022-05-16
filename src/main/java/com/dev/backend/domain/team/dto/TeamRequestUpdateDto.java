package com.dev.backend.domain.team.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamRequestUpdateDto {
    private String teamName;
    private Integer teamYear;
    private Integer teamSemester;

    public TeamRequestUpdateDto(String teamName, Integer teamYear, Integer teamSemester){
        this.teamName = teamName;
        this.teamYear = teamYear;
        this.teamSemester = teamSemester;

    }
}
