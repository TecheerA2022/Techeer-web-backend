package com.dev.backend.domain.team.controller;

import com.dev.backend.domain.team.dto.TeamResponseDto;
import com.dev.backend.domain.team.dto.TeamResponseIdDto;
import com.dev.backend.domain.team.dto.TeamSaveDto;
import com.dev.backend.domain.team.service.TeamService;
import com.dev.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dev.backend.global.utils.Constants.API_PREFIX;

@RequestMapping(API_PREFIX)
@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/teams")
    public List<TeamResponseDto> getList(Model model){
        model.addAttribute("team", teamService.findAll());
        return teamService.findAll();
    }

    @PostMapping("/teams")
    public ResponseEntity save(@RequestBody TeamSaveDto teamSaveDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TeamResponseIdDto.fromEntity(this.teamService.save(teamSaveDto)));
    }
}
