package com.playloud.dto.products;

import java.nio.file.Path;

public record ProductsRequestDto(String title,
                                 String description,
                                 Integer price,
                                 boolean isArchived,
                                 Path file,
                                 Integer categoryId) {
}
