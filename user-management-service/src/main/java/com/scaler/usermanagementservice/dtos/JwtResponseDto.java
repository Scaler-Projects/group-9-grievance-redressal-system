package com.scaler.usermanagementservice.dtos;

import com.scaler.usermanagementservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponseDto {
    public JwtResponseDto(User user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    private User user;
    private String jwtToken;
}
