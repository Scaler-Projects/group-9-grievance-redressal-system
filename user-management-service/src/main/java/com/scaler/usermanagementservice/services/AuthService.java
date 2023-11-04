package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.dtos.*;
import com.scaler.usermanagementservice.exceptions.EmailAlreadyExistsException;
import com.scaler.usermanagementservice.exceptions.UsernameAlreadyExistsException;
import com.scaler.usermanagementservice.helpers.Convert;
import com.scaler.usermanagementservice.models.Role;
import com.scaler.usermanagementservice.models.User;
import com.scaler.usermanagementservice.repositories.RoleRepository;
import com.scaler.usermanagementservice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto signup(UserSignupRequestDto signupDto) throws Exception {

        if (userRepository.existsByEmail(signupDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        if (userRepository.existsByUsername(signupDto.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists.");
        }

        Role userRole = roleRepository.findRoleByName("USER").get();

        User user = new User();
        user.setUsername(signupDto.getUsername());
        user.setPassword(passwordEncoder.encode(signupDto.getPassword()));
        user.setPhone(signupDto.getPhone());
        user.setEmail(signupDto.getEmail());
        Set<Role> roles = new HashSet<>();
        user.setRoles(roles);// comment
        user.setCreated_at(Convert.localDateTimeToLong(LocalDateTime.now()));
        user.setUpdated_at(Convert.localDateTimeToLong(LocalDateTime.now()));

        userRepository.save(user);
        return UserDto.from(user);
    }


    public void setUserRole(UserRoleDto userRoleDto) {
        Optional<User> optionalUser = userRepository.findById(userRoleDto.getUserId());

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = optionalUser.get();
        //user.setRole(userRoleDto.getRole());
        userRepository.save(user);
    }
}
