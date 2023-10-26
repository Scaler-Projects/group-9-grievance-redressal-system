package com.scaler.usermanagementservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String username;
    private String password;

    @Enumerated(value = EnumType.ORDINAL)
    private Role role;
    private String email;
    private String phone;
    private int created_at;
    private int updated_at;
}
