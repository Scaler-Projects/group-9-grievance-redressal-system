package com.scaler.adminmanagementservice.services;

import com.scaler.adminmanagementservice.dtos.AdminDto;
import com.scaler.adminmanagementservice.dtos.GenericAdminDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;
import com.scaler.adminmanagementservice.helper.ConvertTime;
import com.scaler.adminmanagementservice.modals.Role;
import com.scaler.adminmanagementservice.modals.User;
import com.scaler.adminmanagementservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private GenericAdminDto convertToGenericAdminDto(User user) {
        GenericAdminDto genericAdminDto = new GenericAdminDto();
        genericAdminDto.setEmail(user.getEmail());
        genericAdminDto.setUserName(user.getUsername());
        genericAdminDto.setPhone(user.getPhone());
        genericAdminDto.setCreatedAt(user.getCreated_at());
        genericAdminDto.setUpdatedAt(user.getUpdated_at());

        return genericAdminDto;

    }

    private User convertToUser(AdminDto adminDto) {
        User user = new User();
        user.setUsername(adminDto.getUsername());
        user.setPhone(adminDto.getPhone());
        user.setEmail(adminDto.getEmail());
//        user.setUpdated_at(adminDto.getUpdated_at());
        user.setCreated_at(ConvertTime.localDateTimeToLong(LocalDateTime.now()));
        user.setPassword(adminDto.getPassword());
        user.setRole(Role.ADMIN);

        return user;
    }

    @Override
    public GenericAdminDto getAdminById(Long id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return convertToGenericAdminDto(user.get());
        }
        throw new NotFoundException("Admin with id:" + id + " " + "doesn't exist");
    }

    @Override
    public List<GenericAdminDto> getAllAdmins() {
        List<GenericAdminDto> genericAdminDtos = new ArrayList<>();
        List<User> users = userRepository.findAllAdmins();

        for (User u : users) {
            GenericAdminDto genericAdminDto = new GenericAdminDto();
            genericAdminDto.setUserName(u.getUsername());
            genericAdminDto.setEmail(u.getEmail());
            genericAdminDto.setPhone(u.getPhone());
            genericAdminDto.setUpdatedAt(u.getUpdated_at());
            genericAdminDto.setCreatedAt(u.getCreated_at());
            genericAdminDtos.add(genericAdminDto);

        }
        return genericAdminDtos;
    }

    @Override
    public ResponseEntity<String> createAdmin(AdminDto adminDto) {
        User user = convertToUser(adminDto);
        userRepository.save(user);
        return new ResponseEntity<>("Admin created successfully", HttpStatus.CREATED);
        //validation remaining for if already exist

    }

    @Override
    public ResponseEntity<String> updateAdmin(Long id, AdminDto adminDto) throws NotFoundException {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            User newUser = user.get();
            newUser.setPassword(adminDto.getPassword());
            newUser.setUsername(adminDto.getUsername());
            newUser.setEmail(adminDto.getEmail());
            newUser.setPhone(adminDto.getPhone());
            newUser.setUpdated_at(ConvertTime.localDateTimeToLong(LocalDateTime.now()));
//          newUser.setCreated_at(adminDto.getCreated_at());
            this.userRepository.save(newUser);
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        }
        throw new NotFoundException("Admin with id: " + id + " not found to update");
        
//        Validation remaining for if perticular value already exist


    }

    @Override
    public ResponseEntity<String> deleteAdmninById(Long id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("Admin with id: " + id + " deleted", HttpStatus.OK);
        }
        throw new NotFoundException("Admin with id: " + id + " doesn't exist");
    }
}
