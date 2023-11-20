package com.scaler.usermanagementservice.controllers;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.exceptions.NotFoundException;
import com.scaler.usermanagementservice.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initRolesAndUsers() {
        this.userService.initUsers();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable("user_id") Long user_id) {
        UserDto userDto = this.userService.getUserDetails(user_id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<UserDto> updateUserDetails(@PathVariable("user_id") Long user_id,
                                                     @RequestBody UserDto userDto) throws Exception {
        UserDto updatedUser = this.userService.updateUserDetails(user_id, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("user_id") Long user_id) throws NotFoundException {
        this.userService.deleteUser(user_id);
        return ResponseEntity.ok(null);
    }
}
