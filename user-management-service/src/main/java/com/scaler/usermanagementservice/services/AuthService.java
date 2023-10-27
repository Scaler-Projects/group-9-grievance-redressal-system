package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.dtos.UserLoginRequesetDto;
import com.scaler.usermanagementservice.dtos.UserLogoutRequestDto;
import com.scaler.usermanagementservice.dtos.UserSignupRequestDto;

public interface AuthService {
    UserDto signup(UserSignupRequestDto userSignupRequestDto);
    UserDto login(UserLoginRequesetDto userLoginRequesetDto);
    void logout(UserLogoutRequestDto userLogoutRequestDto);
}
