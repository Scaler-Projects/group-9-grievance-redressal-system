package com.scaler.usermanagementservice.controllers;

import com.scaler.usermanagementservice.dtos.*;
import com.scaler.usermanagementservice.services.AuthService;
import com.scaler.usermanagementservice.services.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserSignupRequestDto request) {
        UserDto userDto = this.authService.signup(request);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody UserLogoutRequestDto request) {
        jwtService.logout(request.getUsername());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping({"/login"})
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto request) throws Exception {
        String token = this.jwtService.authenticateUser(request.getUsername(), request.getPassword());

        if (token == null) return ResponseEntity.badRequest().build();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PostMapping({"/setUserRoleToAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Void> setUserRoleToAdmin(@RequestBody UserRoleDto userRoleDto) {
        authService.setUserRoleToAdmin(userRoleDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
