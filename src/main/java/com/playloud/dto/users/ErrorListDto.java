package com.playloud.dto.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ErrorListDto(@JsonProperty("statusCode") String statusCode,
                           @JsonProperty("message") List<String> message,
                           @JsonProperty("error") String error) {

    public static ErrorListDto of(String statusCode,
                              List<String> message,
                              String error) {
        return new ErrorListDto(statusCode,message,error);
    }
}
