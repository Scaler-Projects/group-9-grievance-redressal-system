package com.scaler.usermanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequestDto {
    private String username;
    private String email;
    private String password;
    private String phone;
}
