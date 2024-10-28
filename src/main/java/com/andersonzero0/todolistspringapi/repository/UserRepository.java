package com.andersonzero0.todolistspringapi.repository;

import com.andersonzero0.todolistspringapi.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserDetails findByUsername(String username);
}
