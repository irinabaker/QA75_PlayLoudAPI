package com.playloud.dto.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponseDto(@JsonProperty("accessToken") String token) {

    public static LoginResponseDto of(String token) {
        return new LoginResponseDto(token);
    }
}
