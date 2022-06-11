package com.dev.backend.domain.user.controller;

import com.dev.backend.domain.user.User;
import com.dev.backend.domain.user.dto.SignUpRequest;
import com.dev.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 여기서는 뭘 담아서 보내줘야 할까요?
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        System.out.println(signUpRequest.getEmail());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.signUp(signUpRequest));
    }
}
