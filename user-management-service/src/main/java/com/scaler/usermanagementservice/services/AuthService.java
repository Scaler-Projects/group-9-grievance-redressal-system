package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.dtos.UserRoleDto;
import com.scaler.usermanagementservice.dtos.UserSignupRequestDto;

public interface AuthService {
    UserDto signup(UserSignupRequestDto userSignupRequestDto);

    void setUserRole(UserRoleDto userRoleDto);
}
