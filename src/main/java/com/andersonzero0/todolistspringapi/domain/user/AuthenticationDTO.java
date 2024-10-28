package com.andersonzero0.todolistspringapi.domain.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        String username,

        @NotBlank
        String password) {
}
