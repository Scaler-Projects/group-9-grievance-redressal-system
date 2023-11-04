package com.scaler.adminmanagementservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Long created_at;
    private Long updated_at;

}
