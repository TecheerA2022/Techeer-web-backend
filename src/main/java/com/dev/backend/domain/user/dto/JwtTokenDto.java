package com.dev.backend.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtTokenDto {
    private String accessToken;
    private String refreshToken;

    public static JwtTokenDto of(String accessToken, String refreshToken) {
        return new JwtTokenDto(accessToken, refreshToken);
    }
}
