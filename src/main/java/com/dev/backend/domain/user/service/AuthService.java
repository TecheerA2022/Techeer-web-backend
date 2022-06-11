package com.dev.backend.domain.user.service;

import com.dev.backend.domain.user.User;
import com.dev.backend.domain.user.UserRepository;
import com.dev.backend.domain.user.auth.util.JwtTokenProvider;
import com.dev.backend.domain.user.dto.LoginRequest;
import com.dev.backend.domain.user.dto.LoginResponse;
import com.dev.backend.domain.user.exception.NotExistUserException;
import com.dev.backend.domain.user.exception.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(NotExistUserException::new);
        validatePassword(loginRequest, user);
        return LoginResponse.of(user, jwtTokenProvider.createTokens(user));
    }

    private void validatePassword(LoginRequest loginRequest, User user) {
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }
    }
}
