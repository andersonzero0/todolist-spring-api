package com.andersonzero0.todolistspringapi.domain.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

public record TaskInputDTO(
        Integer id,

        @NotNull
        @NotBlank
        Integer user_id,

        @NotNull
        @NotBlank
        String title,

        @NotNull
        @NotBlank
        String description,

        Boolean done,

        Boolean is_deleted,

        LocalDateTime createdAt,

        LocalDateTime updatedAt) {

        @Builder
        public TaskInputDTO {
                if (done == null) {
                        done = false;
                }
                if (is_deleted == null) {
                        is_deleted = false;
                }
        }
}
