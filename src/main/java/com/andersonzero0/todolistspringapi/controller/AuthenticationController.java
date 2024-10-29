package com.andersonzero0.todolistspringapi.controller;

import com.andersonzero0.todolistspringapi.domain.user.*;
import com.andersonzero0.todolistspringapi.infra.security.TokenService;
import com.andersonzero0.todolistspringapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authManager, UserService userService, TokenService tokenService) {
        this.authManager = authManager;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody @Valid RegisterUserDTO data) {
         var user = this.userService.registerUser(new UserEntity(data));

         if(user == null) {
             throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User already exists");
         }

        return ResponseEntity.ok(new RegisterResponseDTO(user.getUsername(), user.getRole()));
    }
}
