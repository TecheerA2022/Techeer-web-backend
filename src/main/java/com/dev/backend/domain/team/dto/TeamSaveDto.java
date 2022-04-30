package com.dev.backend.domain.team.dto;

import com.dev.backend.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamSaveDto {
    private String teamName;
    private Integer teamYear;
    private Integer teamSemester;

    private Team toEntity() {
        return Team.builder()
                .teamName(teamName)
                .teamYear(teamYear)
                .teamSemester(teamSemester)
                .build();
    }
}
