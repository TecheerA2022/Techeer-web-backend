package com.dev.backend.domain.team.service;

import com.dev.backend.domain.team.Team;
import com.dev.backend.domain.team.TeamRepository;
import com.dev.backend.domain.team.dto.TeamSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public Long save(TeamSaveDto teamSaveDto) {
        Team team = Team.builder()
                .teamName(teamSaveDto.getTeamName())
                .teamYear(teamSaveDto.getTeamYear())
                .teamSemester(teamSaveDto.getTeamSemester())
                .build();
        return teamRepository.save(team).getId();
    }
}
