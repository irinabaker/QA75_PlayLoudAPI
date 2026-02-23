package com.playloud.dto.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryResponseDto(Integer id,
                                  String title,
                                  String slug) {

    public static CategoryResponseDto of(Integer id, String title, String slug){
        return new CategoryResponseDto(id,title,slug);
    }
}
