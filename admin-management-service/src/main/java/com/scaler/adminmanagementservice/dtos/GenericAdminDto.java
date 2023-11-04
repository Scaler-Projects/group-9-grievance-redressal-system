package com.scaler.adminmanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericAdminDto {
    private String userName;
    private String email;
    private Long createdAt;
    private String phone;
    private Long updatedAt;
}
