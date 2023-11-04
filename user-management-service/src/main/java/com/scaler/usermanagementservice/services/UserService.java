package com.scaler.usermanagementservice.services;


import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.exceptions.NotFoundException;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserDetails(Long userId);

    UserDto updateUserDetails(Long userId, UserDto userDto) throws Exception;

    void deleteUser(Long userId) throws NotFoundException;

    void initUsers();
}
