package com.playloud.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsersResponseDto(@JsonProperty("id") String id,
                               @JsonProperty("name") String name,
                               @JsonProperty("email") String email) {

    public static UsersResponseDto of(String id,
                                   String name,
                                   String email) {
        return new UsersResponseDto(id, name, email);
    }
}
