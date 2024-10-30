package com.andersonzero0.todolistspringapi.domain.task;

import java.time.LocalDateTime;

public record TaskResponseDTO(
        Integer id,
        Integer user_id,
        String title,
        String description,
        Boolean done,
        Boolean is_deleted,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public TaskResponseDTO (TaskEntity entity) {
        this(entity.getId(), entity.getUser_id(), entity.getTitle(), entity.getDescription(), entity.getDone(), entity.getIs_deleted(), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
