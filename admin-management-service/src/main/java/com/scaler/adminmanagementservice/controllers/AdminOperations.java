package com.scaler.adminmanagementservice.controllers;

import com.scaler.adminmanagementservice.dtos.GenericAdminDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface AdminOperations {
    @GetMapping("id")
    public GenericAdminDto getAdminById(@PathVariable("id") Long id);

    @GetMapping
    public List<GenericAdminDto> getAllAdmins();

    @PostMapping()
    public GenericAdminDto createAdmin(@RequestBody GenericAdminDto admin);

    @DeleteMapping("{id}")
    public GenericAdminDto deleteAdmin(@PathVariable("id") Long id);

    @PutMapping("{id}")
    public GenericAdminDto updateById(@PathVariable("id") Long id,@RequestBody GenericAdminDto admin);
}
