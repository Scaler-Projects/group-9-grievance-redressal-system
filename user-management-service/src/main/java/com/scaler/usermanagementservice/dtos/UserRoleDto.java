package com.scaler.usermanagementservice.dtos;

import com.scaler.usermanagementservice.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto {
    private Role role;
    private Long userId;
}
