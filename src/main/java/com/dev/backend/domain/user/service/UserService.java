package com.dev.backend.domain.user.service;

import com.dev.backend.domain.user.User;
import com.dev.backend.domain.user.UserRepository;
import com.dev.backend.domain.user.dto.SignUpRequest;
import com.dev.backend.domain.user.exception.AlreadyExistUserIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User signUp(SignUpRequest signUpRequest) {
        User user = signUpRequest.toUser(passwordEncoder);
        checkAlreadySignUp(user);
        User signUpUser = userRepository.save(user);
        return signUpUser;
    }

    private void checkAlreadySignUp(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(m -> { throw new AlreadyExistUserIdException(); });
    }
}
