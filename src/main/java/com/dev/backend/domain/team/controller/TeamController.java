package com.dev.backend.domain.team.controller;

import com.dev.backend.domain.team.dto.TeamResponseIdDto;
import com.dev.backend.domain.team.dto.TeamSaveDto;
import com.dev.backend.domain.team.service.TeamService;
import com.dev.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.dev.backend.global.utils.Constants.API_PREFIX;

@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamService teamService;

    @PostMapping(API_PREFIX + "/teams")
    public ResponseEntity save(@RequestBody TeamSaveDto teamSaveDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TeamResponseIdDto.fromEntity(this.teamService.save(teamSaveDto)));
    }
}
