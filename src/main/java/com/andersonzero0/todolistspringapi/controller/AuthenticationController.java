package com.andersonzero0.todolistspringapi.controller;

import com.andersonzero0.todolistspringapi.domain.user.AuthenticationDTO;
import com.andersonzero0.todolistspringapi.domain.user.RegisterUserDTO;
import com.andersonzero0.todolistspringapi.domain.user.UserEntity;
import com.andersonzero0.todolistspringapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authManager;
    private final UserService userService;

    public AuthenticationController(AuthenticationManager authManager, UserService userService) {
        this.authManager = authManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody @Valid RegisterUserDTO data) {
        return ResponseEntity.ok(this.userService.registerUser(new UserEntity(data)));
    }
}
