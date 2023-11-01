package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.exceptions.EmailAlreadyExistsException;
import com.scaler.usermanagementservice.exceptions.NotFoundException;
import com.scaler.usermanagementservice.dtos.UserDto;
import com.scaler.usermanagementservice.helpers.Convert;
import com.scaler.usermanagementservice.models.Role;
import com.scaler.usermanagementservice.models.User;
import com.scaler.usermanagementservice.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
            String updatedPassword = passwordEncoder.encode(userDto.getPassword());
            user.setPassword(updatedPassword);
        }

        if (userDto.getEmail() != null && !userDto.getEmail().equals(user.getEmail())
                && userRepository.existsByEmail(userDto.getEmail()))
            throw new EmailAlreadyExistsException("Email is already in use");

        user.setUpdated_at(Convert.localDateTimeToLong(LocalDateTime.now()));
    }

    @Override
    public void initRolesAndUsers() {

        User adminUser = new User();
        adminUser.setUsername("superAdmin");
        adminUser.setEmail("superAdmin@email.com");
        adminUser.setPassword(passwordEncoder.encode("admin123"));
        adminUser.setPhone("5555555555555");
        adminUser.setRole(Role.ADMIN);
        adminUser.setCreated_at(Convert.localDateTimeToLong(LocalDateTime.now()));
        adminUser.setUpdated_at(Convert.localDateTimeToLong(LocalDateTime.now()));

        userRepository.save(adminUser);

        User defaultUser = new User();
        defaultUser.setUsername("defaultUser");
        defaultUser.setEmail("defaultUser@email.com");
        defaultUser.setPassword(passwordEncoder.encode("default123"));
        defaultUser.setPhone("44444444444444");
        defaultUser.setRole(Role.USER);
        defaultUser.setCreated_at(Convert.localDateTimeToLong(LocalDateTime.now()));
        defaultUser.setUpdated_at(Convert.localDateTimeToLong(LocalDateTime.now()));

        userRepository.save(defaultUser);
    }
}
