package com.scaler.usermanagementservice.controllers;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.dtos.UserSignupRequestDto;
import com.scaler.usermanagementservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<UserDto> signup(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        UserDto userDto = this.authService.signup(userSignupRequestDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
