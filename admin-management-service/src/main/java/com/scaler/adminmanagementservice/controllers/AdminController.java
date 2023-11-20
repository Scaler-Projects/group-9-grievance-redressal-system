package com.scaler.adminmanagementservice.controllers;

import com.scaler.adminmanagementservice.dtos.AdminDto;
import com.scaler.adminmanagementservice.dtos.GenericAdminDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;
import com.scaler.adminmanagementservice.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController implements AdminOperations {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @Override
    public GenericAdminDto getAdminById(Long id) throws NotFoundException {
        return adminService.getAdminById(id);
    }

    @Override
    public List<GenericAdminDto> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @Override
    public ResponseEntity<GenericAdminDto> createAdmin(AdminDto adminDto) {
        return new ResponseEntity<>(adminService.createAdmin(adminDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GenericAdminDto> updateAdmin(Long id, AdminDto adminDto) throws NotFoundException {
        return new ResponseEntity<>(adminService.updateAdmin(id, adminDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAdminById(Long id) throws NotFoundException {
        return new ResponseEntity<>(adminService.deleteAdmninById(id), HttpStatus.NO_CONTENT);
    }
}
