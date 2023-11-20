package com.scaler.adminmanagementservice.controllers;

import com.scaler.adminmanagementservice.dtos.AdminDto;
import com.scaler.adminmanagementservice.dtos.GenericAdminDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admins")
public interface AdminOperations {

    @GetMapping("{id}")
    GenericAdminDto getAdminById(@PathVariable("id") Long id) throws NotFoundException;

    @GetMapping()
    List<GenericAdminDto> getAllAdmins();

    @PostMapping()
    ResponseEntity<GenericAdminDto> createAdmin(@RequestBody AdminDto adminDto);

    @PutMapping("{id}")
    ResponseEntity<GenericAdminDto> updateAdmin(@PathVariable("id") Long id, @RequestBody AdminDto adminDto) throws NotFoundException;

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteAdminById(@PathVariable("id") Long id) throws NotFoundException;

}
