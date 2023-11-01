package com.scaler.usermanagementservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel {
    private String username;

    private String password;
    private Role role;

    private String email;
    private String phone;
    private Long created_at;
    private Long updated_at;
}
