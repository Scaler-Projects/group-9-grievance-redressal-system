package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.models.Role;
import com.scaler.usermanagementservice.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
