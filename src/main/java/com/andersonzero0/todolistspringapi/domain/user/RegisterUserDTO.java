package com.andersonzero0.todolistspringapi.domain.user;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserDTO(
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        UserRole role
) {
}
