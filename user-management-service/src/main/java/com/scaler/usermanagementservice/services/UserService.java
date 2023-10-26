package com.scaler.usermanagementservice.services;


import com.scaler.usermanagementservice.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserDetails(Long userId);
}
