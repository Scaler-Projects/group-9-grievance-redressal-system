package com.scaler.usermanagementservice.controllers;

import com.scaler.usermanagementservice.models.Role;
import com.scaler.usermanagementservice.services.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}