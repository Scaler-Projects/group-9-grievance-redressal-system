package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.dtos.UserRoleDto;
import com.scaler.usermanagementservice.dtos.UserSignupRequestDto;
import com.scaler.usermanagementservice.helpers.Convert;
import com.scaler.usermanagementservice.models.Role;
import com.scaler.usermanagementservice.models.User;
import com.scaler.usermanagementservice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import lombok.Setter;

@Setter
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDto signup(UserSignupRequestDto signupDto) {
        User user = new User();
        user.setUsername(signupDto.getUsername());
        user.setPassword(passwordEncoder.encode(signupDto.getPassword()));
        user.setPhone(signupDto.getPhone());
        user.setEmail(signupDto.getEmail());
        user.setRole(Role.USER);// comment
        user.setCreated_at(Convert.localDateTimeToLong(LocalDateTime.now()));
        user.setUpdated_at(Convert.localDateTimeToLong(LocalDateTime.now()));

        userRepository.save(user);
        return UserDto.from(user);
    }

    @Override
    public void setUserRole(UserRoleDto userRoleDto) {
        Optional<User> optionalUser = userRepository.findById(userRoleDto.getUserId());

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = optionalUser.get();
        user.setRole(userRoleDto.getRole());
        userRepository.save(user);
    }
}
