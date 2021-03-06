package com.dev.backend.domain.team.service;

import com.dev.backend.domain.team.Team;
import com.dev.backend.domain.team.TeamRepository;
import com.dev.backend.domain.team.dto.TeamRequestUpdateDto;
import com.dev.backend.domain.team.dto.TeamResponseDto;
import com.dev.backend.domain.team.dto.TeamResponseIdDto;
import com.dev.backend.domain.team.dto.TeamSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamResponseIdDto save(TeamSaveDto teamSaveDto) {
        Team team = Team.builder()
                .teamName(teamSaveDto.getTeamName())
                .teamYear(teamSaveDto.getTeamYear())
                .teamSemester(teamSaveDto.getTeamSemester())
                .build();
        return toIdDto(teamRepository.save(team).getId());
    }

    public List<TeamResponseDto> findAll(){
        return teamRepository.findAll()
                .stream()
                .map(TeamResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(String teamName){
        Team team = findByTeamName(teamName);
        teamRepository.deleteById(team.getId());
    }

    public Team findByTeamName(String teamName){

        return teamRepository.findByTeamName(teamName).orElseThrow(EntityExistsException::new);

    }

    public TeamResponseIdDto update(String teamName, TeamRequestUpdateDto requestDto){
        Team team = findByTeamName(teamName);
        team.update(requestDto.getTeamName(), requestDto.getTeamYear(),
                requestDto.getTeamSemester());
        teamRepository.save(team);

        return toIdDto(team.getId());

    }

    public TeamResponseIdDto toIdDto(Long id){
        return TeamResponseIdDto.fromEntity(id);
    }


}
