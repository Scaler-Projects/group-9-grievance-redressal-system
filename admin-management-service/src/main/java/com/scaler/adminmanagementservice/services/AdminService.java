package com.scaler.adminmanagementservice.services;

import com.scaler.adminmanagementservice.dtos.AdminDto;
import com.scaler.adminmanagementservice.dtos.GenericAdminDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;

import java.util.List;

public interface AdminService {
    GenericAdminDto getAdminById(Long id) throws NotFoundException;

    List<GenericAdminDto> getAllAdmins();

    GenericAdminDto createAdmin(AdminDto adminDto);

    GenericAdminDto updateAdmin(Long id, AdminDto adminDto) throws NotFoundException;

    String deleteAdmninById(Long id) throws NotFoundException;
}
