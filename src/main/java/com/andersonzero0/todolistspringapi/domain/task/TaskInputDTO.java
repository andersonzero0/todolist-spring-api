package com.andersonzero0.todolistspringapi.domain.task;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TaskInputDTO(
        Integer id,

        @NotBlank
        String title,

        @NotBlank
        String description,

        Boolean done,

        LocalDateTime createdAt,

        LocalDateTime updatedAt) {
}
