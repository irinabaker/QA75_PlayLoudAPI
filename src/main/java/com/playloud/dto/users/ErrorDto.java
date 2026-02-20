package com.playloud.dto.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorDto(@JsonProperty("statusCode") String statusCode,
                       @JsonProperty("message") String message,
                       @JsonProperty("error") String error) {

    public static ErrorDto of(String statusCode,
                              String message,
                              String error) {
        return new ErrorDto(statusCode, message, error);
    }
}
