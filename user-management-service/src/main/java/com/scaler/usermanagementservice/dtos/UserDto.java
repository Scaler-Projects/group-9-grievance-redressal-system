package com.scaler.usermanagementservice.dtos;

import com.scaler.usermanagementservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private int role;
    private String email;
    private String phone;
    private int created_at;
    private int updated_at;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole().ordinal());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setCreated_at(user.getCreated_at());
        userDto.setUpdated_at(user.getUpdated_at());

        return userDto;
    }
}
