package com.scaler.usermanagementservice.services;


import com.scaler.usermanagementservice.exceptions.EmailAlreadyExistsException;
import com.scaler.usermanagementservice.exceptions.NotFoundException;
import com.scaler.usermanagementservice.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserDetails(Long userId);

    UserDto updateUserDetails(Long userId, UserDto userDto) throws NotFoundException, EmailAlreadyExistsException;

    void deleteUser(Long userId) throws NotFoundException;
}
