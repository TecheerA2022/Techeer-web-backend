package com.dev.backend.domain.user.dto;

import com.dev.backend.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private JwtTokenDto tokens;

    public static LoginResponse of(User user, JwtTokenDto tokens) {
        return new LoginResponse(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                tokens
        );
    }
}
