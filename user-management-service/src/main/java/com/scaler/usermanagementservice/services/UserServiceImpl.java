package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.models.User;
import com.scaler.usermanagementservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserDetails(Long userId) {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        return optionalUser.map(UserDto::from).orElse(null);
    }

    @Override
    public UserDto updateUserDetails(Long userId, UserDto userDto) {
        Optional<User> optionalUser = this.userRepository.findById(userId);

        return null;
    }
}
