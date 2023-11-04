package com.scaler.usermanagementservice.dtos;

import com.scaler.usermanagementservice.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {
    private User user;
    private String jwtToken;
}
