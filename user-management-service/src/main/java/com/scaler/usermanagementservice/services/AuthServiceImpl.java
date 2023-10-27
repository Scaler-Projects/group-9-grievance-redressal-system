package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.dtos.UserLoginRequesetDto;
import com.scaler.usermanagementservice.dtos.UserLogoutRequestDto;
import com.scaler.usermanagementservice.dtos.UserSignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public UserDto signup(UserSignupRequestDto userSignupRequestDto) {
        return null;
    }

    @Override
    public UserDto login(UserLoginRequesetDto userLoginRequesetDto) {
        return null;
    }

    @Override
    public void logout(UserLogoutRequestDto userLogoutRequestDto) {

    }
}
