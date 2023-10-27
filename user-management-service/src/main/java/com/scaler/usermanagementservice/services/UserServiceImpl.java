package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.exceptions.EmailAlreadyExistsException;
import com.scaler.usermanagementservice.exceptions.NotFoundException;
import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.models.User;
import com.scaler.usermanagementservice.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
    public UserDto updateUserDetails(Long userId, UserDto userDto) throws NotFoundException, EmailAlreadyExistsException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) throw new NotFoundException("User Not Found");
        
        User user = optionalUser.get();
        
        validateAndUpdateUser(user, userDto);
        this.userRepository.save(user);

        return UserDto.from(user);
    }


    @Override
    public void deleteUser(Long userId) throws NotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) throw new NotFoundException("User Not Found");

        User user = optionalUser.get();
        this.userRepository.delete(user);
    }


    private void validateAndUpdateUser(User user, UserDto userDto) throws EmailAlreadyExistsException {
        if (userDto.getPhone() != null) {
            user.setPhone(userDto.getPhone());
        }

        if (userDto.getPassword() != null) {
            String updatedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
            user.setPassword(updatedPassword);
        }

        if (userDto.getEmail() != null && !userDto.getEmail().equals(user.getEmail())
                && userRepository.existsByEmail(userDto.getEmail()))
            throw new EmailAlreadyExistsException("Email is already in use");

        user.setUpdated_at((int) new Date().getTime() / 1000);
    }
}
