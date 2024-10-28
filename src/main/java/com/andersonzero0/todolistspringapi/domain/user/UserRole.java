package com.andersonzero0.todolistspringapi.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("admin"),
    USER_ROLE("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

}
