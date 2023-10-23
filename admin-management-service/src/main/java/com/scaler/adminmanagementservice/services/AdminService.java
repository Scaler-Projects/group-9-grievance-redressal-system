package com.scaler.adminmanagementservice.services;

import com.scaler.adminmanagementservice.dtos.GenericAdminDto;

import java.util.List;

public interface AdminService {
    GenericAdminDto getAdminById(Long id);

    List<GenericAdminDto> getAllAdmins();

    GenericAdminDto createAdmin(GenericAdminDto admin);

    GenericAdminDto deleteAdminById(Long id);

    GenericAdminDto updateProduct(Long id, GenericAdminDto admin);

}
