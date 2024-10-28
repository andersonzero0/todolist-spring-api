package com.andersonzero0.todolistspringapi.service;

import com.andersonzero0.todolistspringapi.domain.user.UserEntity;
import com.andersonzero0.todolistspringapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity registerUser(UserEntity userEntity) {
        if(this.userRepository.findByUsername(userEntity.getUsername()) != null) {
            return null;
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(userEntity.getPassword());

        UserEntity newUser = new UserEntity(userEntity.getUsername(), encryptedPassword, userEntity.getRole());

        return this.userRepository.save(newUser);
    }
}
