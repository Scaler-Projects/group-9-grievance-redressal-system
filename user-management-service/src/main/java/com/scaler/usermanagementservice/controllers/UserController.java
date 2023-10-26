package com.scaler.usermanagementservice.controllers;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable("user_id") Long user_id) {
        UserDto userDto = this.userService.getUserDetails(user_id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/user_id")
    public ResponseEntity<UserDto> updateUserDetails(@PathVariable("user_id") Long user_id, @RequestBody UserDto userDto) {
        UserDto updatedUser = this.userService.updateUserDetails(user_id, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
