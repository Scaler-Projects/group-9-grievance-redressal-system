package com.scaler.adminmanagementservice.modals;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "idgenerator")
    @GenericGenerator(name = "idgenerator", strategy = "increment")
    private Long id;

    //    @Column(unique = true)
    private String username;

    //    @Column(unique = true)
    private String password;

    private String phone;
    private String email;
    private Role role;
    private Long created_at;
    private Long updated_at;
}
