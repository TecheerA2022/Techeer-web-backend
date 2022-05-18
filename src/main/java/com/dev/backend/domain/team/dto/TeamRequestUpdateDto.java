package com.dev.backend.domain.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestUpdateDto {
    private String teamName;
    private Integer teamYear;
    private Integer teamSemester;

}
