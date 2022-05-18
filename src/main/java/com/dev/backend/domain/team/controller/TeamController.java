package com.dev.backend.domain.team.controller;

import com.dev.backend.domain.team.dto.TeamRequestUpdateDto;
import com.dev.backend.domain.team.dto.TeamResponseDto;
import com.dev.backend.domain.team.dto.TeamResponseIdDto;
import com.dev.backend.domain.team.dto.TeamSaveDto;
import com.dev.backend.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dev.backend.global.utils.Constants.API_PREFIX;

@RequestMapping(API_PREFIX + "/teams")
@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<TeamResponseDto> getList(){
        return teamService.findAll();
    }

    @PostMapping
    public ResponseEntity<TeamResponseIdDto> save(@RequestBody TeamSaveDto teamSaveDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(teamService.save(teamSaveDto));
        } catch (DataIntegrityViolationException exception){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT).body(TeamResponseIdDto.builder().id(null).build());
        }

    }


    @DeleteMapping("/{teamName}")
    public ResponseEntity<String> deleteTeam(@PathVariable String teamName) {
        teamService.delete(teamName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("deleteOneItem");
    }

    @PutMapping("/{teamName}")
    public ResponseEntity<TeamResponseIdDto> update(@PathVariable String teamName, @RequestBody TeamRequestUpdateDto requestDto){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(teamService.update(teamName, requestDto));
        } catch (DataIntegrityViolationException exception){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT).body(TeamResponseIdDto.builder().id(null).build());
        }
    }

}
